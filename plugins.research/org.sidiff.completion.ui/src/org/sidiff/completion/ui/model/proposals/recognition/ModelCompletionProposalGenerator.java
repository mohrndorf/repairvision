package org.sidiff.completion.ui.model.proposals.recognition;
import java.util.ArrayList;
import java.util.Collections;import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposalCluster;
import org.sidiff.completion.ui.model.proposals.recognition.impact.ModelCompletionImpactAnalyzes;
import org.sidiff.completion.ui.model.proposals.util.DecompositionTemplates;
import org.sidiff.completion.ui.proposals.CompletionProposalList;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.history.revision.IRevision;
import org.sidiff.history.revision.impl.Revision;
import org.sidiff.integration.editor.access.ActiveModelEditorAccess;
import org.sidiff.revision.difference.api.settings.DifferenceSettings;
import org.sidiff.revision.repair.complement.peo.finder.ComplementFinderEngine;
import org.sidiff.revision.repair.ui.config.RepairPreferencePage;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class ModelCompletionProposalGenerator {

	private List<Rule> editRules;
	
	private ActiveModelEditorAccess editorAccess;
	
	private List<EObject> context;
	
	private Resource historicModel;
	
	private Resource currentModel;
	
	public ModelCompletionProposalGenerator(ActiveModelEditorAccess editorAccess, List<Rule> editRules, List<EObject> context) {
		this.editorAccess = editorAccess;
		this.editRules = editRules;
		this.context = context;
	}

	public void generateProposals(CompletionProposalList proposalList) {
		populateSettings();
		calculateProposals(proposalList);

	}

	protected Resource getCurrentModel() {
		if (currentModel == null) {
			currentModel = editorAccess.getModelResource();
		}
		return currentModel;
	}

	protected Resource getHistoricModel() {
		if (historicModel == null) {
			// Load last saved model version:
			URI modelURI = editorAccess.getModelResource().getURI();
			return new ResourceSetImpl().getResource(modelURI, true);
		}
		return historicModel;
	}
	
	// org.sidiff.revision.repair.ui.app.impl.EMFResourceRepairApplication<J, F>:
	
	protected void populateSettings() {
		if (getCurrentModel() != null) {
			RepairPreferencePage.populateSettings(getCurrentModel());
		} else if (getHistoricModel() != null) {
			RepairPreferencePage.populateSettings(getHistoricModel());
		}
	}
	
	protected DifferenceSettings getMatchingSettings() {
		return RepairPreferencePage.getMatchingSettings();
	}
	
	protected String getDoumentType() {
		return RepairPreferencePage.getDoumentType();
	}
	
	protected List<Rule> getEditRules() {
		return editRules;
	}
	
	protected ImpactAnalyzes getImpactAnalyzes(IRevision revision) {
		// Positive -> Current impact on context:
		// Negative -> Historic impact on context:
		return new ModelCompletionImpactAnalyzes(revision, context);
	}
	
	// org.sidiff.revision.repair.api.peo.PEORepairCalculationEngine
	
	private IRevision calculateDifference() {
		DifferenceSettings differenceSettings = getMatchingSettings();
		IRevision revision = new Revision(getHistoricModel(), getCurrentModel(), differenceSettings);
		return revision;
	}
	
	private void calculateProposals(CompletionProposalList proposalList) {
		
		// Model difference between historical and current version:
		IRevision revision = calculateDifference();
		
		// Completion change impact:
		ImpactAnalyzes impactAnalyzes = getImpactAnalyzes(revision);
		
		// Henshin graph:
		EGraph graphCurrentModel = new EGraphImpl(getCurrentModel());
		
		// Calculate proposals:
		ComplementFinderEngine complementFinderEngine = new ComplementFinderEngine(revision, null, graphCurrentModel);
		complementFinderEngine.start();
		
		List<ModelCompletionProposalCluster> propsalClusters = new ArrayList<>();
		
		// Sort the edit rules by size of their sub-rules starting with the largest.
		sortEditRules(getEditRules());
		
		for (Rule editRule : getEditRules()) {
			ModelCompletionProposalCaculation proposalCaculation = new ModelCompletionProposalCaculation(editRule, impactAnalyzes, complementFinderEngine);
			
//			if (editRule.getName().contains("Create: TransitionWithCallEventTriggerAndOperationInClass")) {
//				System.out.println("ModelCompletionProposalGenerator.calculateProposals()");
//			}
			
			if (proposalCaculation.isPotentialProposal()) {
				List<ModelCompletionProposal> proposalsForEditRule = proposalCaculation.findProposals();
				
				// TODO: Make this configurable: Plain proposals
//				proposalList.addProposals(proposalsForEditRule);
				
				// Integrate into proposal clusters:
				for (ModelCompletionProposal proposalCandidate : proposalsForEditRule) {
					DecompositionTemplates candidateDecomposition = proposalCandidate.getDecomposition();
					boolean addedToAtLeastOneCluster = false;
					
					for (ModelCompletionProposalCluster propsalCluster : propsalClusters) {
						ModelCompletionProposalCluster proposalClusterForEditRule = propsalCluster.add(
								proposalCandidate, candidateDecomposition);
						
						// Is fork?
						if ((proposalClusterForEditRule != null) && (proposalClusterForEditRule != propsalCluster)) {
							propsalClusters.add(proposalClusterForEditRule);
						}
						
						if (proposalClusterForEditRule != null) {
							addedToAtLeastOneCluster = true;
						}
					}
					
					// No matching cluster found?
					if (!addedToAtLeastOneCluster) {
						propsalClusters.add(new ModelCompletionProposalCluster(proposalCandidate, candidateDecomposition));
					}
				}
			}
		}
		
		proposalList.addProposals(propsalClusters);
	}

	private void sortEditRules(List<Rule> editRules) {
	
		Collections.sort(editRules, new Comparator<Rule>() {

			@Override
			public int compare(Rule rule1, Rule rule2) {
				
				if ((rule1 instanceof RuleExtension) && (rule2 instanceof RuleExtension)) {
					Integer size1 = ((RuleExtension) rule1).getSubgraphs().size();
					Integer size2 = ((RuleExtension) rule2).getSubgraphs().size();
					return size2.compareTo(size1);
				}
				
				return 0;
			}
		});
	}
}
