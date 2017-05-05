package org.sidiff.graphpattern.matcher.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.sidiff.common.ui.InfoConsole;
import org.sidiff.graphpattern.DataStore;
import org.sidiff.graphpattern.EObjectList;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.graphpattern.matcher.IPatternMatchingEngine;
import org.sidiff.graphpattern.matcher.domain.DomainSet;
import org.sidiff.graphpattern.matcher.ui.session.EngineManager;
import org.sidiff.graphpattern.matcher.ui.util.SiriusUtil;
import org.sidiff.graphpattern.matcher.util.MatchingUtil;

public class MatchViewerApp {

	/**
	 * Empty selection console message.
	 */
	public static final String MSG_EMPTY_SELECTION = "Please select a match!";

	/**
	 * The tree viewer showing the matchings.
	 */
	private TreeViewer viewer_matching;
	
	/**
	 * The EMF-Model viewer showing the variable assignments.
	 */
	private TreeViewer viewer_variables;
	
	/**
	 * All matched nodes of the graph pattern.
	 */
	private List<NodePattern> graphPattern;
	
	/**
	 * All variable assignments.
	 */
	private List<EObjectList> variableAssignments;
	
	/**
	 * All graph pattern matchings
	 */
	private List<EObjectList> allMatchings;

	public MatchViewerApp(TreeViewer viewer_matching, TreeViewer viewer_variables) {
		this.viewer_matching = viewer_matching;
		this.viewer_variables = viewer_variables;
	}

	public void generateMatches() {
		Job job = new Job("Generate the matchings") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				// Calculate matchings:
				IPatternMatchingEngine<? extends IMatching> engine = EngineManager.getInstance().getMatchingEngine();
				Iterator<? extends IMatching> matchIterator = engine.getResults();
				List<NodePattern> variableNodes = engine.getVariableNodes();
				
				variableAssignments = new ArrayList<>();
				allMatchings = new ArrayList<>();
				graphPattern = engine.getGraphPattern();
						
				int matchingCount = 0;
				
				while (true) {
					long timeStart = System.currentTimeMillis(); 
					
					if (matchIterator.hasNext()) {
						IMatching match = matchIterator.next();

						long stopTime = System.currentTimeMillis();
						
						InfoConsole.printInfos(Collections.emptyList(), "Match Generation Time: " 
								+ ((stopTime - timeStart) / 1000.0) + "s");
						
						addVariableMatch(variableNodes, match);
						allMatchings.add(MatchingUtil.createMatching(engine.getVariableNodes(), match));
						
						++matchingCount;
					} else {
						break;
					}
				}
				
				// Clean up matching engine:
				EngineManager.getInstance().stopEngine();
				
				// UI updates:				
				Display.getDefault().syncExec(() -> {
					
					// Show matches to the UI:
					EObjectList matchingList = GraphpatternFactory.eINSTANCE.createEObjectList();
					matchingList.setLabel("Matchings");
					matchingList.getContent().addAll(allMatchings);
					
					MatchViewerApp.this.viewer_matching.setInput(matchingList);
					MatchViewerApp.this.viewer_matching.refresh();
					
					EObjectList assignmentList = GraphpatternFactory.eINSTANCE.createEObjectList();
					assignmentList.setLabel("Variable Assignments");
					assignmentList.getContent().addAll(variableAssignments);
					
					MatchViewerApp.this.viewer_variables.setInput(assignmentList);
					MatchViewerApp.this.viewer_variables.refresh();
				});
				
				// Print infos:
				for (EObjectList variableMatch : variableAssignments) {
					InfoConsole.printInfos(variableMatch.getContent());
				}
				
				InfoConsole.printInfo(matchingCount + " matches found!");
				
				return Status.OK_STATUS;
			}
		};

		// Start the Job
		job.schedule(); 
	}
	
	private void addVariableMatch(List<NodePattern> variableNodes, IMatching matching) {
		EObjectList assignment = GraphpatternFactory.eINSTANCE.createEObjectList();
		
		for (NodePattern variableNode : variableNodes) {
			EObject match = matching.getFirstMatch(variableNode);
			
			if (match != null) {
				assignment.getContent().add(match);
			}
		}
		
		assignment.setLabel("Variable Assignment [" + assignment.getContent().size() + "/" + matching.getNodes().size() + "]");
		variableAssignments.add(assignment);
	}

	public void setMatch(EObjectList match) {

		for (NodePattern node : graphPattern) {
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(node);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					EObject matchEntry = match.getContent().get(graphPattern.indexOf(node));
					DataStore ds = new DomainSet();
					node.getEvaluation().setStore(ds);

					if (matchEntry instanceof EObjectList) {
						for (EObject match : ((EObjectList) matchEntry).getContent()) {
							ds.addMatch(match);
						}
					}
					
					else if (matchEntry != MatchingUtil.EMPTY_MATCH) {
						ds.addMatch(match);
					}
				}

				@Override
				public boolean canUndo() {
					return false;
				}
			});
		}
		SiriusUtil.refreshActiveEditor();
	}

	public void printSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			InfoConsole.printInfo(selectedElement, MSG_EMPTY_SELECTION);
		}
	}
}
