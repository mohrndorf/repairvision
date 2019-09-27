package org.sidiff.graphpattern.tools.editrules.constructors;

import java.util.Collections;
import java.util.List;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.tools.editrules.constructors.util.EditRuleCollector;
import org.sidiff.graphpattern.tools.editrules.filter.IEditRuleFilter;
import org.sidiff.graphpattern.tools.editrules.generator.GraphPatternEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil;

/**
 * Constructs deletion rules for (complex) graph patterns.
 * 
 * @author Manuel Ohrndorf
 */
public class DeletionEditRuleConstructor implements IEditRuleConstructor {

	@Override
	public void construct(Pattern patterns, List<IEditRuleFilter> filter, EditRuleCollector editRules) {
		
		// Generate edit rules:
		for (GraphPattern graphPattern : patterns.getGraphs()) {
			
//			if (graphPattern.getName().contains("Containment-Container and Containment Reference")) {
//				System.out.println(graphPattern.getName());
//			}
			
			GraphPatternEditRuleGenerator generator = new GraphPatternEditRuleGenerator(graphPattern, null, Collections.emptyMap());
			generator.generate(graphPattern.getNodes(), Collections.emptyList());
			generator.setName("Delete: " + graphPattern.getName());
			
			Pattern editOperation = generator.getEditOperation();
			GraphPattern editRule = generator.getEditRule();
			
			// Add context and conditions:
			GraphPatternGeneratorUtil.removePseudoResourceNode(editRule);
			
			// Add new edit rule for graph pattern:
			if (!IEditRuleFilter.filter(filter, editOperation, editRule, editRules.getRulebase())) {
				editRules.add(graphPattern, editOperation);
			} else {
				System.err.println("INFO: Filtered edit rule: " + editRule.getName());
			}
		}
		
		// Generate sub-patterns:
		for (Pattern subPattern : patterns.getSubpatterns()) {
			construct(subPattern, filter, editRules);
		}
	}
}
