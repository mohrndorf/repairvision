package org.sidiff.repair.complement.peo.construction;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.view.AttributePair;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.editrule.partialmatcher.scope.RepairActionFilter;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.complement.util.ComplementUtil;

public class SettingAttributeFilter {

	public static void filterSettingAttributes(Rule complementRule, 
			EditOperationMatching prematch, RepairActionFilter repairActionFilter) {
		
		// Keep only the given attributes in the complement rule:
		// Get all << set >> attributes in << create >> nodes:
		for(Attribute complementAttribute : ChangePatternUtil.getSettingAttributes(complementRule)) {
			
			// Remove only input parameters -> filter constant values:
			if (complementRule.getParameter(complementAttribute.getValue()) != null) {
				if (!repairActionFilter.filter(Collections.singletonList(complementAttribute), prematch.getMatch())) {
					complementAttribute.getNode().getAttributes().remove(complementAttribute);
				}
			}
		}
		
		// Get all << set >> attributes in << preserve >> nodes:
		for(AttributePair complementAttributePair : ChangePatternUtil.getChangingAttributes(complementRule)) {
			Attribute complementAttribute = complementAttributePair.getRhsAttribute();
			
			// Remove only input parameters -> filter constant values:
			if (complementRule.getParameter(complementAttribute.getValue()) != null) {
				if (!repairActionFilter.filter(Collections.singletonList(complementAttribute), prematch.getMatch())) {
					complementAttribute.getNode().getAttributes().remove(complementAttribute);
				}
			}
		}
		
		// Substitute already set << create >> attributes:
		for (AttributePair attribute : ChangePatternUtil.getChangingAttributes(complementRule)) {
			Node node = HenshinRuleAnalysisUtilEx.getLHS(attribute.getRhsAttribute().getNode());
			EObject match = prematch.getMatch().getNodeTarget(node);

			if (match != null) {
				Object valueB = match.eGet(attribute.getType());
				String valueRHS = attribute.getRhsAttribute().getValue();
				Parameter parameter = complementRule.getParameter(valueRHS);

				// Parameter or constant value?
				if (parameter != null) {
					Object parameterValue = prematch.getMatch().getParameterValue(parameter);

					if ((valueB).equals(parameterValue)) {
						ComplementUtil.makePreserve(attribute.getRhsAttribute());
					}
				} else {

					// Convert string value:
					if (valueRHS.startsWith("\"") && valueRHS.endsWith("\"")) {
						valueRHS = valueRHS.substring(1, valueRHS.length() - 1);
					}

					// Check constant value:
					if ((valueB + "").equals(valueRHS)) {
						ComplementUtil.makePreserve(attribute.getRhsAttribute());
					}
				}
			}
		}
	}
}
