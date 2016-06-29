package org.sidiff.consistency.repair.complement.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyParameter;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyPreserveNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getPreservedNodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RestrictedEGraphImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.view.EdgePair;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMultiMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

/**
 * Constructs the complement-rule = source-rule (-) partial-edit-rule-match.
 * Requires that the context of the complement-rule can be completely matched.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementConstructorCompleteContext extends ComplementConstructor {

	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;
	
	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graph;
	
	/**
	 * @param sourceRule
	 *            The partially executed edit-rule.
	 * @param engine
	 *            The (Henshin) engine which applies the rules.
	 * @param graph
	 *            The working graph, i.e. the actual version of the model.
	 */
	public ComplementConstructorCompleteContext(Rule sourceRule, EngineImpl engine, EGraph graph) {
		super(sourceRule);
		this.engine = engine;
		this.graph = graph;
	}

	@Override
	protected List<ComplementMatch> initializeComplementPrematch(
			ComplementRule complement, Collection<EditRuleMatch> sourceRuleMatching) {
		
		// Create rule which only contains the context nodes:
		Rule contextRule = HenshinFactory.eINSTANCE.createRule();
		Graph contextLHS = HenshinFactory.eINSTANCE.createGraph();
		Graph contextRHS = HenshinFactory.eINSTANCE.createGraph();
		contextRule.setLhs(contextLHS);
		contextRule.setRhs(contextRHS);
		
		Map<Node, Node> traceContextToComplement = new HashMap<>();
		Map<Node, Node> traceComplementToContext = new HashMap<>();
		
		for (NodePair preserveNodeComplement : getPreservedNodes(complement.getComplementRule())) {
			NodePair preserveNodeContext = copyPreserveNodes(contextRule, preserveNodeComplement, true);
			
			traceComplementToContext.put(preserveNodeComplement.getLhsNode(), preserveNodeContext.getLhsNode());
			traceComplementToContext.put( preserveNodeComplement.getRhsNode(), preserveNodeContext.getRhsNode());
			
			traceContextToComplement.put(preserveNodeContext.getLhsNode(), preserveNodeComplement.getLhsNode());
			traceContextToComplement.put(preserveNodeContext.getRhsNode(), preserveNodeComplement.getRhsNode());
		}
		
		for (EdgePair preserveEdgeComplement : getPreservedEdges(complement.getComplementRule())) {
			copyEdge(
					preserveEdgeComplement.getLhsEdge(), 
					traceComplementToContext.get(preserveEdgeComplement.getLhsEdge().getSource()),
					traceComplementToContext.get(preserveEdgeComplement.getLhsEdge().getTarget()));
			
			copyEdge(
					preserveEdgeComplement.getRhsEdge(), 
					traceComplementToContext.get(preserveEdgeComplement.getRhsEdge().getSource()),
					traceComplementToContext.get(preserveEdgeComplement.getRhsEdge().getTarget()));
		}
		
		for (Parameter parameter : complement.getComplementRule().getParameters()) {
			copyParameter(contextRule, parameter);
		}
		
		// Create restricted graph:
		RestrictedEGraphImpl restrictedGraph = new RestrictedEGraphImpl(graph, engine, contextRule);
		
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleNodeMatch) {
				if (sourceRuleMatch.getAction().equals(Type.PRESERVE)) {
					Node sourceNode = ((EditRuleNodeMatch) sourceRuleMatch).getNode();
					Node complementNode = complement.getTrace(sourceNode);
					EditRuleNodeMatch preMatch = (EditRuleNodeMatch) sourceRuleMatch;
					
					if (preMatch instanceof EditRuleNodeSingleMatch) {
						EditRuleNodeSingleMatch singlePreMatch = (EditRuleNodeSingleMatch) preMatch;
						restrictedGraph.setDomainRestriction(complementNode, singlePreMatch.getModelElement());
					}
					
					else if (preMatch instanceof EditRuleNodeMultiMatch) {
						EditRuleNodeMultiMatch multiPreMatch = (EditRuleNodeMultiMatch) preMatch;
						restrictedGraph.setDomainRestriction(complementNode, multiPreMatch.getModelElements());
					}
				}
			}
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<ComplementMatch> complementPreMatches = new ArrayList<>();
		complement.setComplementPreMatches(complementPreMatches);
		Iterator<Match> matchFinder = engine.findMatches(contextRule, restrictedGraph, null).iterator();
		
		if (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			ComplementMatch nextComplementMatch = new ComplementMatch(new HashMap<>());
			complementPreMatches.add(nextComplementMatch);
			
			for (Node contextNode : contextLHS.getNodes()) {
				nextComplementMatch.getNodeMatches().put(traceContextToComplement.get(contextNode), nextMatch.getNodeTarget(contextNode));
			}
		}
		
		complementPreMatches.trimToSize();
		return complementPreMatches;
	}

}
