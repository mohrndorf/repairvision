package org.sidiff.repair.history.evolution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.consistency.common.storage.UUIDMatcher;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.technical.api.TechnicalDifferenceFacade;
import org.sidiff.difference.technical.api.settings.DifferenceSettings;
import org.sidiff.editrule.recognition.util.LiftingGraphIndex;
import org.sidiff.historymodel.ChangeSet;
import org.sidiff.historymodel.HistoryModelFactory;
import org.sidiff.historymodel.Problem;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.repair.history.evaluation.driver.data.InconsistencyTrace;
import org.sidiff.repair.history.evolution.difference.DifferenceExecutor;
import org.sidiff.repair.history.evolution.difference.SymmetricDifferenceUtil;
import org.sidiff.validation.constraint.api.ValidationFacade;
import org.sidiff.validation.constraint.api.util.ContextValidationFilter;
import org.sidiff.validation.constraint.api.util.RepairValidation;
import org.sidiff.validation.constraint.api.util.Validation;
import org.sidiff.validation.constraint.interpreter.IConstraint;
import org.sidiff.validation.constraint.interpreter.decisiontree.IDecisionNode;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction;
import org.sidiff.validation.constraint.interpreter.repair.RepairAction.RepairType;

/*
 * TODO: Es sollte auch ermittelt werden, ob während einer Reparatur 
 * negative Seiteneffekte auftreten, welche aber ebenfalls innerhalb
 * der Differenz bzw. Historie repariert werden.
 */
public class InconsistencyAnalysis {

	private InconsistencyTrace inconsistency;

	public InconsistencyAnalysis(Problem introducedValidationError) {
		this.inconsistency = InconsistencyTrace.createRepairedInconsistency(introducedValidationError, false);
	}
	
	protected SymmetricDifference calculateDifference(Resource modelA, Resource modelB, IMatcher matcher) {
		
		DifferenceSettings settings = new DifferenceSettings();
		settings.setMergeImports(false);
		settings.setMatcher(matcher);
		settings.setCorrespondencesService(
				CorrespondencesUtil.getAvailableCorrespondencesService(
						MatchingModelCorrespondences.SERVICE_ID));

		try {
			return TechnicalDifferenceFacade.deriveTechnicalDifference(modelA, modelB, settings);
		} catch (InvalidModelException | NoCorrespondencesException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<ChangeSet> getCausingChanges() {
		
		// - aktuellen Reparaturbaum berechnen
		// - alle Undos bezüglich der Differenz H -> I und dem Reparaturbaum berechnen
		// - Statespace Exploration
		//   - (1) jeder Zweig des Reparaturbaums muss untersucht werden
		//      - Alternativen generieren
		//      - nur reine Undo-Alternativen betrachten
		//      - Undo-Alternativen durch Undo-Aktionen aus der Differenz initialisieren
		//   - eine Alternative ausführen -> für Backtracking merken
		//   - erneut validieren
		//   - Undo fortsetzen:
		//     - solange die Inkonsistenz nicht behoben wurde wieder bei (1) beginnen
		//   - Backtracking zur nächsten Undo-Alternative:
		//     - Wenn die Inkonsistenz behoben wurde, die durchgeführten (inversen) Änderungen als
		//       auslösendes Change-Set speichern.
		//     - Wenn keine Undo-Alternativen mehr existieren und die Inkonsistenz nicht behoben wurde, 
		//       dann kann der Zweig des Reparaturbaums verworfen werden. 
		
		// NOTE:
		// - Der selbe Algorithmus wie bei Resolved-Changes -> Differenz invertieren: I -> H
		// - Interessant sind ggf. auch die Anzahl der nötigen Reparaturbäume bis eine Inkonsistenz behoben wurde.
		
		// Calculate inverse difference: historical -> introduced
		Resource historical = inconsistency.getModelHistorical();
		Resource introduced = inconsistency.getModelIntroduced();
		SymmetricDifference difference = calculateDifference(introduced, historical, new UUIDMatcher());
		
		LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);
		changeIndex.initialize();

		// Explore repairs (undos):
		List<Set<Change>> repairSteps = new ArrayList<>();
		EObject context = inconsistency.getProblemIntroducedModel().getContextElement();
		IConstraint constraint = inconsistency.getConsistencyRule(ValidationFacade.getConstraints(introduced));
		
		// TODO: Initialization of attribute values!?
		explore(constraint, new ArrayList<>(),
				context, introduced, new Stack<>(),
				difference, changeIndex, 
				repairSteps, new HashSet<>());
		
		// Add implicit repairs:
		addImplicitRepairs(constraint, context, introduced, changeIndex, repairSteps);
		
		return createChangeSets(repairSteps, true);
	}
	
	public List<ChangeSet> getResolvedChanges() {
		
		// - aktuellen Reparaturbaum berechnen
		// - alle durchgeführten Reparaturen bezüglich der Differenz I -> R und dem Reparaturbaum berechnen
		// - Statespace Exploration
		//   - (1) jeder Zweig des Reparaturbaums muss untersucht werden
		//      - Alternativen generieren
		//      - nur reine Applied-Alternativen betrachten
		//      - Applied-Alternativen durch Aktionen aus der Differenz initialisieren
		//   - eine Alternative ausführen -> für Backtracking merken
		//   - erneut validieren
		//   - Reparatur fortsetzen:
		//     - solange die Inkonsistenz nicht behoben wurde wieder bei (1) beginnen
		//   - Backtracking zur nächsten Applied-Alternative:
		//     - Wenn die Inkonsistenz behoben wurde, die durchgeführten Änderungen als
		//       auslösendes Change-Set speichern.
		//     - Wenn keine Applied-Alternativen mehr existieren und die Inkonsistenz nicht behoben wurde, 
		//       dann kann der Zweig des Reparaturbaums verworfen werden. 
		
		// Calculate inverse difference: historical -> introduced
		Resource introduced = inconsistency.getModelIntroduced();
		Resource resolved = inconsistency.getModelResolved();
		SymmetricDifference difference = calculateDifference(introduced, resolved, new UUIDMatcher());
		
		LiftingGraphIndex changeIndex = new LiftingGraphIndex(difference);
		changeIndex.initialize();

		// Explore repairs:
		List<Set<Change>> repairSteps = new ArrayList<>();
		EObject context = inconsistency.getProblemIntroducedModel().getContextElement();
		IConstraint constraint = inconsistency.getConsistencyRule(ValidationFacade.getConstraints(introduced));
		
		// TODO: Initialization of attribute values!?
		explore(constraint, new ArrayList<>(), 
				context, introduced, new Stack<>(),
				difference, changeIndex, 
				repairSteps, new HashSet<>());
		
		// Add implicit repairs:
		addImplicitRepairs(constraint, context, introduced, changeIndex, repairSteps);
		
		return createChangeSets(repairSteps, false);
	}

	protected void explore(
			IConstraint constraint, List<RepairAction> repairFilter, 
			EObject context, Resource inconsistent, Stack<DifferenceExecutor> exploration,
			SymmetricDifference difference, LiftingGraphIndex changeIndex, 
			List<Set<Change>> repairSteps, Set<Change> currentRepairStep) {
		
		// Calculate repair alternatives:
		// TODO: Preprocessing: Filter branches with no observable repair actions.
		List<RepairValidation> validations = ValidationFacade.repair(inconsistent, 
				Collections.singletonList(constraint),
				new ContextValidationFilter(Collections.singleton(context)));
		
		// NOTE: Only one validation expected!
		assert (validations.size() == 1);
		
		for (RepairValidation validation : validations) {
			validation.cleanUpRepairTree();
			validation.getRepair().combinations().forEachRemaining(repair -> {
				
				// Focus on current repair path -> has new repairs?
				/*
				 * TODO:
				 * 
				 * Alle Reparaturenalternativen die bereits zuvor vorhanden waren und damit
				 * keine logische Fortsetzung der bisherigen Reparatur sind müssen ausgefilter
				 * werden. Korrekt müsste man hier prüfen, dass die aktuelle
				 * Reparaturalternative nicht bereits in einem vorherigen Reparaturbaum
				 * vorhanden war. Durch die aktelle überlappungsprüfung wird ggf. zu viel
				 * ausgefiltert.
				 * 
				 * Anstelle des Filters könnte man auch prüfen, das mindestens eine
				 * Reparaturaktion/Änderung der aktuellen Reparaturalternative von den
				 * vorherigen Reparaturaktionen/Änderungen abh�ngt!?
				 * 
				 */
				if (!overlappingRepairs(repair, repairFilter)) {
					List<List<Change>> observedRepairs = getObservable(repair, changeIndex,  currentRepairStep, exploration);
					
					// Filter combinations with missing observable repair actions:
					if (observedRepairs != null) {
						for (List<Change> observedRepairStep : cartesianProduct(observedRepairs)) {
							
							// Apply observed changes:
							SymmetricDifferenceUtil.addOppositeChanges(changeIndex, observedRepairStep);
							
							DifferenceExecutor differenceExecutor = new DifferenceExecutor(difference, observedRepairStep);
							differenceExecutor.execute();
							exploration.push(differenceExecutor);
							
							currentRepairStep.addAll(observedRepairStep);
							
							// Check if inconsistency is resolved:
							List<Validation> revalidations = Collections.emptyList();
							
							// NOTE: The context might be deleted!
							if (context.eResource() != null) {
								revalidations = ValidationFacade.validate(inconsistent,
										Collections.singletonList(constraint), 
										new ContextValidationFilter(Collections.singleton(context)));
							}
							
							if (revalidations.isEmpty()) {
								// Remember current repair step:
								Set<Change> finalRepairStep = new HashSet<>(currentRepairStep);
								repairSteps.add(finalRepairStep);
							} else {
								// Next step:
								List<RepairAction> addedRepairs = addMissingRepairs(validation.getRepair(), repairFilter);
								
								explore(constraint, repairFilter, 
										context, inconsistent, exploration,
										difference, changeIndex, 
										repairSteps, currentRepairStep);
								
								// Backtracking:
								repairFilter.removeAll(addedRepairs);
							}
							
							// Backtracking:
							differenceExecutor.undo();
							exploration.pop();
							currentRepairStep.removeAll(observedRepairStep);

						}
					}	
				}
			});
		}
	}
	
	private List<List<Change>> getObservable(List<? extends IDecisionNode> repair, 
			LiftingGraphIndex changeIndex, Set<Change> changeFilter, 
			Collection<DifferenceExecutor> exploration) {
		
		List<List<Change>> observableRepair = new ArrayList<>();
		
		for (IDecisionNode node : repair) {
			if (node instanceof RepairAction) {
				RepairAction repairAction = (RepairAction) node; 
				List<Change> observedRepair = getObservable(repairAction, changeIndex, changeFilter, exploration);
				
				if (!observedRepair.isEmpty()) {
					observableRepair.add(observedRepair);
				} else {
					return null;
				}
			} else {
				throw new RuntimeException("Unsupported repair action!");
			}
		}
		
		return observableRepair;
	}
	
	private List<Change> getObservable(RepairAction repairAction, 
			LiftingGraphIndex changeIndex, Set<Change> changeFilter, 
			Collection<DifferenceExecutor> exploration) {
		
		List<Change> observedRepair = new ArrayList<>();
		
		EObject repairContextA = repairAction.getContext();
		
		for (Change localChange : changeIndex.getLocalChanges(repairAction.getContext())) {
			if (!changeFilter.contains(localChange)) {
				
				if (localChange instanceof RemoveReference) {
					if (repairAction.getType().equals(RepairType.DELETE) || repairAction.getType().equals(RepairType.MODIFY)) {
						if (repairAction.getFeature().equals(((RemoveReference) localChange).getType())) {
							if (repairAction.getContext() == ((RemoveReference) localChange).getSrc()) {
								observedRepair.add(localChange);
							}
						}
					}
				}
				
				else if (localChange instanceof AttributeValueChange) {
					if (repairAction.getType().equals(RepairType.MODIFY)) {
						if (repairAction.getFeature().equals(((AttributeValueChange) localChange).getType())) {
							observedRepair.add(localChange);
						}
					}
				}
			}
		}
		
		EObject repairContextB = getCorrespondingObjectInB(repairContextA, changeIndex, exploration);
		
		if (repairContextB != null) {
			for (Change localChange : changeIndex.getLocalChanges(repairContextB)) {
				if (!changeFilter.contains(localChange)) {
					
					if (localChange instanceof AddReference) {
						if (repairAction.getType().equals(RepairType.CREATE) || repairAction.getType().equals(RepairType.MODIFY)) {
							if (repairAction.getFeature().equals(((AddReference) localChange).getType())) {
								if (repairContextB == ((AddReference) localChange).getSrc()) {
									observedRepair.add(localChange);
								}
							}
						}
					}
				}
			}
		}
		
		return observedRepair;
	}
	
	private EObject getCorrespondingObjectInB(EObject objA, 
			LiftingGraphIndex changeIndex, 
			Collection<DifferenceExecutor> explorations) {
		
		Correspondence correspondence = changeIndex.getCorrespondenceA(objA);
		
		if (correspondence != null) {
			return correspondence.getMatchedB();
		} else {
			
			for (DifferenceExecutor exploration : explorations) {
				EObject objB = exploration.getCorrespondingObjectInB(objA);
				
				if (objB != null) {
					return objB;
				}
			}
		}
		
		return null;
	}
	
	private <T> List<List<T>> cartesianProduct(List<List<T>> lists) {
	    List<List<T>> cartesianProduct = new ArrayList<List<T>>();
	    
	    if (lists.size() == 0) {
	        cartesianProduct.add(new ArrayList<T>());
	        return cartesianProduct;
	    } else {
	        List<T> firstList = lists.get(0);
	        List<List<T>> remainingLists = cartesianProduct(lists.subList(1, lists.size()));
	        
	        for (T condition : firstList) {
	            for (List<T> remainingList : remainingLists) {
	                ArrayList<T> resultList = new ArrayList<T>();
	                resultList.add(condition);
	                resultList.addAll(remainingList);
	                cartesianProduct.add(resultList);
	            }
	        }
	    }
	    return cartesianProduct;
	}
	
	private void addImplicitRepairs(
			IConstraint constraint, EObject context, Resource inconsistent,
			LiftingGraphIndex changeIndex, List<Set<Change>> introducedChangeSets) {
		
		List<RepairValidation> validations = ValidationFacade.repair(inconsistent, 
				Collections.singletonList(constraint),
				new ContextValidationFilter(Collections.singleton(context)));
		
		// NOTE: Only one validation expected!
		assert (validations.size() == 1);
		
		for (Set<Change> changeSet : introducedChangeSets) {
			for (Change change : changeSet.toArray(new Change[0])) {
				for (Change subsequentChange : SymmetricDifferenceUtil.getSubsequentChanges(changeIndex, change)) {
					
					if (!changeSet.contains(subsequentChange)) {
						
						for (RepairValidation validation : validations) {
							Iterator<? extends IDecisionNode> repairTree = validation.getRepair().traversal();
							
							while (repairTree.hasNext()) {
								IDecisionNode repairTreeNode = repairTree.next();
								
								if (repairTreeNode instanceof RepairAction) {
									List<Change> observables = getObservable(
											(RepairAction) repairTreeNode,
											changeIndex, Collections.emptySet(),
											Collections.emptyList());
									
									for (Change observable : observables) {
										if (observable == subsequentChange) {
											changeSet.add(subsequentChange);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private List<ChangeSet> createChangeSets(List<Set<Change>> changeSets, boolean invert) {
		List<ChangeSet> eChangeSets = new ArrayList<>();
		
		for (Set<Change> changeSet : changeSets) {
			ChangeSet eChangeSet = HistoryModelFactory.eINSTANCE.createChangeSet();
			eChangeSets.add(eChangeSet);
			
			for (Change change : changeSet) {
				if (invert) {
					eChangeSet.getChanges().add(SymmetricDifferenceUtil.invertChange(change));
				} else {
					eChangeSet.getChanges().add(SymmetricDifferenceUtil.copyChange(change));
				}
			}
		}
		
		return eChangeSets;
	}
	
	
	private List<RepairAction> addMissingRepairs(IDecisionNode repairTree, List<RepairAction> repairs) {
		List<RepairAction> missingRepairs = new ArrayList<>();
		
		repairTree.traversal().forEachRemaining(decision -> {
			if (decision instanceof RepairAction) {
				RepairAction repair = (RepairAction) decision;
				
				if (!containsRepair(repairs, repair)) {
					repairs.add(repair);
					missingRepairs.add(repair);
				}
			}
		});
		
		return missingRepairs;
	}
	
	private boolean overlappingRepairs(List<? extends IDecisionNode> repair, List<? extends IDecisionNode> repairsB) {
		
		for (IDecisionNode repairA : repair) {
			if (repairA instanceof RepairAction) {
				for (IDecisionNode repairB : repairsB) {
					if (repairB instanceof RepairAction) {
						if (equalsRepair((RepairAction) repairA, (RepairAction) repairB)) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean containsRepair(List<RepairAction> repairs, RepairAction repair) {
		
		for (RepairAction otherRepair : repairs) {
			if (equalsRepair(repair, otherRepair)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean equalsRepair(RepairAction repairA, RepairAction repairB) {
		
		if (repairA.getType().equals(repairB.getType())) {
			if (repairA.getContext().equals(repairB.getContext())) {
				if (repairA.getFeature().equals(repairB.getFeature())) {
					return true;
				}
			}
		}

		return false;
	}
}
