package org.sidiff.consistency.repair.complement.cpo.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.debug.DebugUtil;
import org.sidiff.consistency.repair.api.matching.EditOperationMatching;
import org.sidiff.consistency.repair.api.matching.EOMatch;
import org.sidiff.consistency.repair.api.matching.EONodeSingleMatch;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;

public class CPOComplementRule extends ComplementRule  {

	public CPOComplementRule(Rule sourceRule, Rule complementRule, EngineImpl engine, EGraph graph) {
		super(sourceRule, complementRule);
		initialize(engine, graph);
	}

	@Override
	protected List<EditOperationMatching> createComplementMatches(List<EOMatch> partialSourceMatch) {
		
		long parameterMatching = System.currentTimeMillis();
		
		// Create complement pre-match by partial source-rule match:
		Match complementPreMatche = new MatchImpl(complementRule);
		
		for (EOMatch sourceMatch : partialSourceMatch) {
			
			// NOTE: The matching unambiguously in CPO approach (regarding EditRuleNodeMultiMatch):
			if (sourceMatch instanceof EONodeSingleMatch) {
				if (!sourceMatch.getAction().equals(Type.DELETE)) {
					EONodeSingleMatch nodeMatch = (EONodeSingleMatch) sourceMatch;
					Node complementNode = getLHS(getTrace(nodeMatch.getNode()));
					
					if (complementNode != null) {
						complementPreMatche.setNodeTarget(complementNode, nodeMatch.getModelBElement());
					}
				}
			}
		}
		
		// Check context rule (with restricted working graph):
		ArrayList<EditOperationMatching> complementMatches = new ArrayList<>();
		Iterator<Match> matchFinder = getEngine().findMatches(complementRule, getGraph(), complementPreMatche).iterator();
		
		while (matchFinder.hasNext()) {
			Match nextMatch = matchFinder.next();
			
			// Create complement pre-match:
			EditOperationMatching nextComplementMatch = new EditOperationMatching(nextMatch);
			complementMatches.add(nextComplementMatch);
		}
		
		if (DebugUtil.statistic) {
			System.out.println("Parameter Matching (" + complementRule.getName() + "): " + (System.currentTimeMillis() - parameterMatching) + "ms");
		}
		
		complementMatches.trimToSize();
		return complementMatches;
	}
}
