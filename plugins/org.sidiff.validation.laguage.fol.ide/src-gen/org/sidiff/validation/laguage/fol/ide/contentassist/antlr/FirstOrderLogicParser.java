/*
 * generated by Xtext 2.10.0
 */
package org.sidiff.validation.laguage.fol.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.sidiff.validation.laguage.fol.ide.contentassist.antlr.internal.InternalFirstOrderLogicParser;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;

public class FirstOrderLogicParser extends AbstractContentAssistParser {

	@Inject
	private FirstOrderLogicGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalFirstOrderLogicParser createParser() {
		InternalFirstOrderLogicParser result = new InternalFirstOrderLogicParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getQuantifierAccess().getAlternatives(), "rule__Quantifier__Alternatives");
					put(grammarAccess.getPrimaryAccess().getAlternatives(), "rule__Primary__Alternatives");
					put(grammarAccess.getTerminalExpressionAccess().getAlternatives(), "rule__TerminalExpression__Alternatives");
					put(grammarAccess.getTerminalExpressionAccess().getValueAlternatives_2_1_0(), "rule__TerminalExpression__ValueAlternatives_2_1_0");
					put(grammarAccess.getConsistencyRuleAccess().getGroup(), "rule__ConsistencyRule__Group__0");
					put(grammarAccess.getGetAccess().getGroup(), "rule__Get__Group__0");
					put(grammarAccess.getGetAccess().getGroup_1(), "rule__Get__Group_1__0");
					put(grammarAccess.getIfAccess().getGroup(), "rule__If__Group__0");
					put(grammarAccess.getIfAccess().getGroup_1(), "rule__If__Group_1__0");
					put(grammarAccess.getXorAccess().getGroup(), "rule__Xor__Group__0");
					put(grammarAccess.getXorAccess().getGroup_1(), "rule__Xor__Group_1__0");
					put(grammarAccess.getOrAccess().getGroup(), "rule__Or__Group__0");
					put(grammarAccess.getOrAccess().getGroup_1(), "rule__Or__Group_1__0");
					put(grammarAccess.getAndAccess().getGroup(), "rule__And__Group__0");
					put(grammarAccess.getAndAccess().getGroup_1(), "rule__And__Group_1__0");
					put(grammarAccess.getNotAccess().getGroup(), "rule__Not__Group__0");
					put(grammarAccess.getForAllAccess().getGroup(), "rule__ForAll__Group__0");
					put(grammarAccess.getExistsAccess().getGroup(), "rule__Exists__Group__0");
					put(grammarAccess.getPrimaryAccess().getGroup_0(), "rule__Primary__Group_0__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_0(), "rule__TerminalExpression__Group_0__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_1(), "rule__TerminalExpression__Group_1__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_2(), "rule__TerminalExpression__Group_2__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_3(), "rule__TerminalExpression__Group_3__0");
					put(grammarAccess.getConsistencyRuleAccess().getTypeAssignment_1(), "rule__ConsistencyRule__TypeAssignment_1");
					put(grammarAccess.getConsistencyRuleAccess().getVariableAssignment_2(), "rule__ConsistencyRule__VariableAssignment_2");
					put(grammarAccess.getConsistencyRuleAccess().getFormulaAssignment_4(), "rule__ConsistencyRule__FormulaAssignment_4");
					put(grammarAccess.getVariableAccess().getNameAssignment(), "rule__Variable__NameAssignment");
					put(grammarAccess.getGetAccess().getFeatureAssignment_1_2(), "rule__Get__FeatureAssignment_1_2");
					put(grammarAccess.getIfAccess().getRightAssignment_1_2(), "rule__If__RightAssignment_1_2");
					put(grammarAccess.getXorAccess().getRightAssignment_1_2(), "rule__Xor__RightAssignment_1_2");
					put(grammarAccess.getOrAccess().getRightAssignment_1_2(), "rule__Or__RightAssignment_1_2");
					put(grammarAccess.getAndAccess().getRightAssignment_1_2(), "rule__And__RightAssignment_1_2");
					put(grammarAccess.getNotAccess().getNotAssignment_2(), "rule__Not__NotAssignment_2");
					put(grammarAccess.getForAllAccess().getBoundedAssignment_2(), "rule__ForAll__BoundedAssignment_2");
					put(grammarAccess.getForAllAccess().getIterationAssignment_4(), "rule__ForAll__IterationAssignment_4");
					put(grammarAccess.getForAllAccess().getFormulaAssignment_6(), "rule__ForAll__FormulaAssignment_6");
					put(grammarAccess.getExistsAccess().getBoundedAssignment_2(), "rule__Exists__BoundedAssignment_2");
					put(grammarAccess.getExistsAccess().getIterationAssignment_4(), "rule__Exists__IterationAssignment_4");
					put(grammarAccess.getExistsAccess().getFormulaAssignment_6(), "rule__Exists__FormulaAssignment_6");
					put(grammarAccess.getTerminalExpressionAccess().getValueAssignment_0_1(), "rule__TerminalExpression__ValueAssignment_0_1");
					put(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1_1(), "rule__TerminalExpression__ValueAssignment_1_1");
					put(grammarAccess.getTerminalExpressionAccess().getValueAssignment_2_1(), "rule__TerminalExpression__ValueAssignment_2_1");
					put(grammarAccess.getTerminalExpressionAccess().getVariableAssignment_3_1(), "rule__TerminalExpression__VariableAssignment_3_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalFirstOrderLogicParser typedParser = (InternalFirstOrderLogicParser) parser;
			typedParser.entryRuleConsistencyRule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public FirstOrderLogicGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(FirstOrderLogicGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
