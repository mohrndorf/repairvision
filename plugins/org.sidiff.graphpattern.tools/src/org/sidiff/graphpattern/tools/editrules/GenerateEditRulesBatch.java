package org.sidiff.graphpattern.tools.editrules;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.rule;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.sidiff.common.emf.modelstorage.EMFHandlerUtil;
import org.sidiff.consistency.common.emf.ModelingUtil;
import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.IDomain;
import org.sidiff.csp.solver.IVariable;
import org.sidiff.csp.solver.impl.CSPSolver;
import org.sidiff.csp.solver.impl.ConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.profile.henshin.HenshinStereotypes;
import org.sidiff.graphpattern.tools.editrules.csp.GraphConstraintMatch;
import org.sidiff.graphpattern.tools.editrules.csp.GraphConstraintMatchings;
import org.sidiff.graphpattern.tools.editrules.generator.GraphPatternEditRuleGenerator;
import org.sidiff.graphpattern.util.GraphPatternUtil;

public class GenerateEditRulesBatch extends AbstractHandler {
	
	private static EClass pseudoResourceClass = GraphpatternPackage.eINSTANCE.getResource();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Bundle patternBundle = EMFHandlerUtil.getSelection(event, Bundle.class);
		
		if (patternBundle != null) {
			
			// Setup edit rule profile:
			patternBundle.getProfiles().add(HenshinStereotypes.profile_model);
			
			// Generate edit rules:
			Map<GraphPattern, List<GraphPattern>> editRules = new HashMap<>();
			
			for (Pattern pattern : patternBundle.getPatterns()) {
				generateCreationRules(pattern, editRules);
				generateDeletionRules(pattern, editRules);
				generateStructuralTransformationRules(pattern, editRules);
			}
			
			editRules.forEach((pattern, rules) -> pattern.getPattern().getGraphs().addAll(rules));
			System.out.println("Edit Rules: " + editRules.values().stream().mapToInt(List::size).sum());
			
			// Save edit rules:
			URI originalURI = patternBundle.eResource().getURI();
			URI editRulesURI = URI.createURI(originalURI.trimFileExtension() + "_editrules").appendFileExtension("graphpattern");
			patternBundle.eResource().setURI(editRulesURI);
			
			try {
				patternBundle.eResource().save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static void generateCreationRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<GraphPattern> creationRules = new ArrayList<>(1);
			
			// Copy graph constraints:
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName("create: " + graphPattern.getName());
			editRule.getStereotypes().add(rule);
			creationRules.add(editRule);
			
			// Set edit rule actions:
			setConstructionAction(editRule, create);
			
			// Add new edit rule for graph pattern:
			editRules.merge(graphPattern, creationRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateCreationRules(subPattern, editRules);
		}
	}
	
	public static void generateDeletionRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : pattern.getGraphs()) {
			List<GraphPattern> deletionRules = new ArrayList<>(1);
			
			// Copy graph constraints:
			GraphPattern editRule = (GraphPattern) ModelingUtil.deepCopy(graphPattern).get(graphPattern);
			editRule.setName("delete: " + graphPattern.getName());
			editRule.getStereotypes().add(rule);
			deletionRules.add(editRule);
			
			// Remove negative graph constraints:
			for (Iterator<NodePattern> iterator = editRule.getNodes().iterator(); iterator.hasNext();) {
				NodePattern node = iterator.next();
				
				if (!node.getStereotypes().isEmpty()) {
					if (node.getStereotypes().contains(not)) {
						node.removeIncident();
						iterator.remove();
					}
				}
			}
			
			// Set edit rule actions:
			setConstructionAction(editRule, delete);
			
			// Add new edit rule for graph pattern:
			editRules.merge(graphPattern, deletionRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : pattern.getSubpatterns()) {
			generateDeletionRules(subPattern, editRules);
		}
	}

	protected static void setConstructionAction(GraphPattern editRule, Stereotype constructionST) {
		
		// Set node actions:
		for (NodePattern node : editRule.getNodes()) {
			
			// Filter negative application conditions:
			if (!node.getStereotypes().contains(not)) {
				
				// Is contained node?
				if (node.getIncomings().stream().anyMatch(e -> e.getType().isContainment())) {
					node.getStereotypes().add(constructionST);
					
					// Set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(constructionST);
					}
				} else {
					
					// Context element:
					node.getStereotypes().add(preserve);
					
					// Set attribute actions:
					for (AttributePattern attribute : node.getAttributes()) {
						attribute.getStereotypes().add(preserve);
					}
				}
				
				
				// Set edge actions:
				for (EdgePattern edge : node.getOutgoings()) {
					
					// Edge between context nodes?
					if (edge.getSource().getStereotypes().contains(preserve)
							&& edge.getTarget().getStereotypes().contains(preserve)) {
						edge.getStereotypes().add(preserve);
					} else {
						edge.getStereotypes().add(constructionST);
					}
				}
			}
		}
		
		// Remove (pseudo) resource node:
		for (Iterator<NodePattern> iterator = editRule.getNodes().iterator(); iterator.hasNext();) {
			NodePattern node = iterator.next();
			
			if (node.getType().equals(pseudoResourceClass)) {
				node.removeIncident();
				iterator.remove();
			}
		}
	}
	
	public static void generateStructuralTransformationRules(Pattern pattern, Map<GraphPattern, List<GraphPattern>> editRules) {
		List<GraphPattern> allConstraints = pattern.getAllGraphPatterns();
		
		// Generate edit rules:
		// Consider cross-product of all graph patterns:
		for (GraphPattern preConstraint : allConstraints) {
			List<GraphPattern> transformationRules = new ArrayList<>();
			
//			if (preConstraint.getName().contains("Class with Unbound Generic Type Parameter")) {
//				System.out.println(preConstraint.getName());
//			} else {
//				continue;
//			}
			
			for (GraphPattern postConstraint : allConstraints) {
				if (preConstraint != postConstraint) {
					
//					if (postConstraint.getName().contains("Class with Bound Generic Type Parameter")) {
//						System.out.println(postConstraint.getName());
//					} else {
//						continue;
//					}

					int preSize = GraphPatternUtil.getPatternSize(preConstraint.getNodes());
					int postSize = GraphPatternUtil.getPatternSize(postConstraint.getNodes());

					// Check if there is a (full) node matching between the graph patterns:
					// Compare the nodes by their assigned class types:
					if ((preSize == postSize) && GraphPatternUtil.isTypeEqual(preConstraint.getNodes(), postConstraint.getNodes())) {
						IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(preConstraint.getNodes().size());
						problem.setMinimumSolutionSize(preSize);
						problem.setMaximumSolutionSize(preSize);
						problem.setSearchMaximumSolutions(true);
						problem.setSearchInjectiveSolutions(true);

						for (NodePattern fromNode : preConstraint.getNodes()) {
							if (!fromNode.getStereotypes().contains(not)) {
								IDomain<NodePattern> domain = GraphConstraintMatchings.getDomain(fromNode, 
										postConstraint.getNodes(), 
										n -> !n.getStereotypes().contains(not));
								IVariable<NodePattern, NodePattern> variable = new Variable<>(fromNode, domain, false);
								problem.addVariable(variable);
							}
						}

						GraphConstraintMatchings matchings = new GraphConstraintMatchings(preConstraint, postConstraint);
						ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
						solver.run();

						String name = "structural transform: "
								+ preConstraint.getName() + " - to - "
								+ postConstraint.getName();

//						System.out.println("[" + matchings.getMatches().size() + "]: " + name);

						// Generate edit rules:
						int counter = 0;
						int count = matchings.getMatches().size();

						for (GraphConstraintMatch match : matchings.getMatches()) {
							GraphPatternEditRuleGenerator editRuleGenerator = new GraphPatternEditRuleGenerator(
									match.getPreConstraint(), 
									match.getPostConstraint(),
									match.getMatch());
							editRuleGenerator.generate(
									match.getPreConstraint().getNodes(), 
									match.getPostConstraint().getNodes());
							GraphPattern transformationRule = editRuleGenerator.getEditRule();

							if (count > 1) {
								transformationRule.setName(name + " (" + ++counter + ")");
							} else {
								transformationRule.setName(name);
							}

							transformationRules.add(transformationRule);
						}
					}
				}
			}
			
			// Add new edit rule for graph pattern:
			editRules.merge(preConstraint, transformationRules, (v1, v2) -> {v1.addAll(v2); return v1;});
		}
	}
}
