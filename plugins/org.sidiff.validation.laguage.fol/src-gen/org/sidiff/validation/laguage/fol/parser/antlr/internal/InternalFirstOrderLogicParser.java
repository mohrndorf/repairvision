package org.sidiff.validation.laguage.fol.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.sidiff.validation.laguage.fol.services.FirstOrderLogicGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFirstOrderLogicParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'domain'", "'import'", "'constraint'", "'message'", "'context'", "':'", "'='", "'implies'", "'xor'", "'or'", "'and'", "'not('", "')'", "'isEqual('", "','", "'isGreater('", "'isGreaterEqual('", "'isSmaller('", "'isSmallerEqual('", "'isEmpty('", "'isInstanceOf('", "'forAll('", "'in'", "'exists('", "'('", "'true'", "'false'", "'.'", "'::'", "'getContainer('", "'getContainments('", "'getClosure('", "'size('", "'concatenate('", "'capitalize('"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalFirstOrderLogicParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFirstOrderLogicParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFirstOrderLogicParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFirstOrderLogic.g"; }



     	private FirstOrderLogicGrammarAccess grammarAccess;

        public InternalFirstOrderLogicParser(TokenStream input, FirstOrderLogicGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ConstraintLibrary";
       	}

       	@Override
       	protected FirstOrderLogicGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleConstraintLibrary"
    // InternalFirstOrderLogic.g:64:1: entryRuleConstraintLibrary returns [EObject current=null] : iv_ruleConstraintLibrary= ruleConstraintLibrary EOF ;
    public final EObject entryRuleConstraintLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintLibrary = null;


        try {
            // InternalFirstOrderLogic.g:64:58: (iv_ruleConstraintLibrary= ruleConstraintLibrary EOF )
            // InternalFirstOrderLogic.g:65:2: iv_ruleConstraintLibrary= ruleConstraintLibrary EOF
            {
             newCompositeNode(grammarAccess.getConstraintLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraintLibrary=ruleConstraintLibrary();

            state._fsp--;

             current =iv_ruleConstraintLibrary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraintLibrary"


    // $ANTLR start "ruleConstraintLibrary"
    // InternalFirstOrderLogic.g:71:1: ruleConstraintLibrary returns [EObject current=null] : (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* ) ;
    public final EObject ruleConstraintLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domain_1_0=null;
        Token otherlv_2=null;
        Token lv_packageImport_3_0=null;
        EObject lv_constraints_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:77:2: ( (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* ) )
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* )
            {
            // InternalFirstOrderLogic.g:78:2: (otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )* )
            // InternalFirstOrderLogic.g:79:3: otherlv_0= 'domain' ( (lv_domain_1_0= RULE_STRING ) ) otherlv_2= 'import' ( (lv_packageImport_3_0= RULE_STRING ) ) ( (lv_constraints_4_0= ruleConstraint ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintLibraryAccess().getDomainKeyword_0());
            		
            // InternalFirstOrderLogic.g:83:3: ( (lv_domain_1_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:84:4: (lv_domain_1_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:84:4: (lv_domain_1_0= RULE_STRING )
            // InternalFirstOrderLogic.g:85:5: lv_domain_1_0= RULE_STRING
            {
            lv_domain_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_domain_1_0, grammarAccess.getConstraintLibraryAccess().getDomainSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintLibraryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domain",
            						lv_domain_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintLibraryAccess().getImportKeyword_2());
            		
            // InternalFirstOrderLogic.g:105:3: ( (lv_packageImport_3_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:106:4: (lv_packageImport_3_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:106:4: (lv_packageImport_3_0= RULE_STRING )
            // InternalFirstOrderLogic.g:107:5: lv_packageImport_3_0= RULE_STRING
            {
            lv_packageImport_3_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            					newLeafNode(lv_packageImport_3_0, grammarAccess.getConstraintLibraryAccess().getPackageImportSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintLibraryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"packageImport",
            						lv_packageImport_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalFirstOrderLogic.g:123:3: ( (lv_constraints_4_0= ruleConstraint ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:124:4: (lv_constraints_4_0= ruleConstraint )
            	    {
            	    // InternalFirstOrderLogic.g:124:4: (lv_constraints_4_0= ruleConstraint )
            	    // InternalFirstOrderLogic.g:125:5: lv_constraints_4_0= ruleConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getConstraintLibraryAccess().getConstraintsConstraintParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_constraints_4_0=ruleConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConstraintLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_4_0,
            	    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Constraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraintLibrary"


    // $ANTLR start "entryRuleConstraint"
    // InternalFirstOrderLogic.g:146:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalFirstOrderLogic.g:146:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalFirstOrderLogic.g:147:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalFirstOrderLogic.g:153:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_message_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_variable_5_0 = null;

        EObject lv_formula_7_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:159:2: ( (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) ) )
            // InternalFirstOrderLogic.g:160:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) )
            {
            // InternalFirstOrderLogic.g:160:2: (otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) ) )
            // InternalFirstOrderLogic.g:161:3: otherlv_0= 'constraint' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'message' ( (lv_message_3_0= RULE_STRING ) ) otherlv_4= 'context' ( (lv_variable_5_0= ruleVariable ) ) otherlv_6= ':' ( (lv_formula_7_0= ruleFormula ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getConstraintKeyword_0());
            		
            // InternalFirstOrderLogic.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:166:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:167:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getMessageKeyword_2());
            		
            // InternalFirstOrderLogic.g:187:3: ( (lv_message_3_0= RULE_STRING ) )
            // InternalFirstOrderLogic.g:188:4: (lv_message_3_0= RULE_STRING )
            {
            // InternalFirstOrderLogic.g:188:4: (lv_message_3_0= RULE_STRING )
            // InternalFirstOrderLogic.g:189:5: lv_message_3_0= RULE_STRING
            {
            lv_message_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_message_3_0, grammarAccess.getConstraintAccess().getMessageSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"message",
            						lv_message_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getConstraintAccess().getContextKeyword_4());
            		
            // InternalFirstOrderLogic.g:209:3: ( (lv_variable_5_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:210:4: (lv_variable_5_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:210:4: (lv_variable_5_0= ruleVariable )
            // InternalFirstOrderLogic.g:211:5: lv_variable_5_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getVariableVariableParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_variable_5_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_5_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getColonKeyword_6());
            		
            // InternalFirstOrderLogic.g:232:3: ( (lv_formula_7_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:233:4: (lv_formula_7_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:233:4: (lv_formula_7_0= ruleFormula )
            // InternalFirstOrderLogic.g:234:5: lv_formula_7_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getFormulaFormulaParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_2);
            lv_formula_7_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_7_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleVariable"
    // InternalFirstOrderLogic.g:255:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalFirstOrderLogic.g:255:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalFirstOrderLogic.g:256:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalFirstOrderLogic.g:262:1: ruleVariable returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:268:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFirstOrderLogic.g:269:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFirstOrderLogic.g:269:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFirstOrderLogic.g:270:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalFirstOrderLogic.g:270:3: ( (otherlv_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:271:4: (otherlv_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:271:4: (otherlv_0= RULE_ID )
            // InternalFirstOrderLogic.g:272:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getTypeEClassifierCrossReference_0_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:283:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFirstOrderLogic.g:284:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFirstOrderLogic.g:284:4: (lv_name_1_0= RULE_ID )
            // InternalFirstOrderLogic.g:285:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleFormula"
    // InternalFirstOrderLogic.g:305:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalFirstOrderLogic.g:305:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalFirstOrderLogic.g:306:2: iv_ruleFormula= ruleFormula EOF
            {
             newCompositeNode(grammarAccess.getFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFormula=ruleFormula();

            state._fsp--;

             current =iv_ruleFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // InternalFirstOrderLogic.g:312:1: ruleFormula returns [EObject current=null] : this_BinaryFormula_0= ruleBinaryFormula ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryFormula_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:318:2: (this_BinaryFormula_0= ruleBinaryFormula )
            // InternalFirstOrderLogic.g:319:2: this_BinaryFormula_0= ruleBinaryFormula
            {

            		newCompositeNode(grammarAccess.getFormulaAccess().getBinaryFormulaParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BinaryFormula_0=ruleBinaryFormula();

            state._fsp--;


            		current = this_BinaryFormula_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleBinaryFormula"
    // InternalFirstOrderLogic.g:330:1: entryRuleBinaryFormula returns [EObject current=null] : iv_ruleBinaryFormula= ruleBinaryFormula EOF ;
    public final EObject entryRuleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:330:54: (iv_ruleBinaryFormula= ruleBinaryFormula EOF )
            // InternalFirstOrderLogic.g:331:2: iv_ruleBinaryFormula= ruleBinaryFormula EOF
            {
             newCompositeNode(grammarAccess.getBinaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryFormula=ruleBinaryFormula();

            state._fsp--;

             current =iv_ruleBinaryFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryFormula"


    // $ANTLR start "ruleBinaryFormula"
    // InternalFirstOrderLogic.g:337:1: ruleBinaryFormula returns [EObject current=null] : this_Iff_0= ruleIff ;
    public final EObject ruleBinaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Iff_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:343:2: (this_Iff_0= ruleIff )
            // InternalFirstOrderLogic.g:344:2: this_Iff_0= ruleIff
            {

            		newCompositeNode(grammarAccess.getBinaryFormulaAccess().getIffParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Iff_0=ruleIff();

            state._fsp--;


            		current = this_Iff_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryFormula"


    // $ANTLR start "entryRuleIff"
    // InternalFirstOrderLogic.g:355:1: entryRuleIff returns [EObject current=null] : iv_ruleIff= ruleIff EOF ;
    public final EObject entryRuleIff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIff = null;


        try {
            // InternalFirstOrderLogic.g:355:44: (iv_ruleIff= ruleIff EOF )
            // InternalFirstOrderLogic.g:356:2: iv_ruleIff= ruleIff EOF
            {
             newCompositeNode(grammarAccess.getIffRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIff=ruleIff();

            state._fsp--;

             current =iv_ruleIff; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIff"


    // $ANTLR start "ruleIff"
    // InternalFirstOrderLogic.g:362:1: ruleIff returns [EObject current=null] : (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* ) ;
    public final EObject ruleIff() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_If_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:368:2: ( (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* ) )
            // InternalFirstOrderLogic.g:369:2: (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* )
            {
            // InternalFirstOrderLogic.g:369:2: (this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )* )
            // InternalFirstOrderLogic.g:370:3: this_If_0= ruleIf ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )*
            {

            			newCompositeNode(grammarAccess.getIffAccess().getIfParserRuleCall_0());
            		
            pushFollow(FOLLOW_11);
            this_If_0=ruleIf();

            state._fsp--;


            			current = this_If_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:378:3: ( () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:379:4: () otherlv_2= '=' ( (lv_right_3_0= ruleIf ) )
            	    {
            	    // InternalFirstOrderLogic.g:379:4: ()
            	    // InternalFirstOrderLogic.g:380:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIffAccess().getIffLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,17,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIffAccess().getEqualsSignKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:390:4: ( (lv_right_3_0= ruleIf ) )
            	    // InternalFirstOrderLogic.g:391:5: (lv_right_3_0= ruleIf )
            	    {
            	    // InternalFirstOrderLogic.g:391:5: (lv_right_3_0= ruleIf )
            	    // InternalFirstOrderLogic.g:392:6: lv_right_3_0= ruleIf
            	    {

            	    						newCompositeNode(grammarAccess.getIffAccess().getRightIfParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_right_3_0=ruleIf();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIffRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.If");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIff"


    // $ANTLR start "entryRuleIf"
    // InternalFirstOrderLogic.g:414:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalFirstOrderLogic.g:414:43: (iv_ruleIf= ruleIf EOF )
            // InternalFirstOrderLogic.g:415:2: iv_ruleIf= ruleIf EOF
            {
             newCompositeNode(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIf=ruleIf();

            state._fsp--;

             current =iv_ruleIf; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalFirstOrderLogic.g:421:1: ruleIf returns [EObject current=null] : (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Xor_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:427:2: ( (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* ) )
            // InternalFirstOrderLogic.g:428:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            {
            // InternalFirstOrderLogic.g:428:2: (this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )* )
            // InternalFirstOrderLogic.g:429:3: this_Xor_0= ruleXor ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            {

            			newCompositeNode(grammarAccess.getIfAccess().getXorParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_Xor_0=ruleXor();

            state._fsp--;


            			current = this_Xor_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:437:3: ( () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:438:4: () otherlv_2= 'implies' ( (lv_right_3_0= ruleXor ) )
            	    {
            	    // InternalFirstOrderLogic.g:438:4: ()
            	    // InternalFirstOrderLogic.g:439:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getIfAccess().getIfLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,18,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getIfAccess().getImpliesKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:449:4: ( (lv_right_3_0= ruleXor ) )
            	    // InternalFirstOrderLogic.g:450:5: (lv_right_3_0= ruleXor )
            	    {
            	    // InternalFirstOrderLogic.g:450:5: (lv_right_3_0= ruleXor )
            	    // InternalFirstOrderLogic.g:451:6: lv_right_3_0= ruleXor
            	    {

            	    						newCompositeNode(grammarAccess.getIfAccess().getRightXorParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_right_3_0=ruleXor();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIfRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Xor");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleXor"
    // InternalFirstOrderLogic.g:473:1: entryRuleXor returns [EObject current=null] : iv_ruleXor= ruleXor EOF ;
    public final EObject entryRuleXor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXor = null;


        try {
            // InternalFirstOrderLogic.g:473:44: (iv_ruleXor= ruleXor EOF )
            // InternalFirstOrderLogic.g:474:2: iv_ruleXor= ruleXor EOF
            {
             newCompositeNode(grammarAccess.getXorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXor=ruleXor();

            state._fsp--;

             current =iv_ruleXor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXor"


    // $ANTLR start "ruleXor"
    // InternalFirstOrderLogic.g:480:1: ruleXor returns [EObject current=null] : (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) ;
    public final EObject ruleXor() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Or_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:486:2: ( (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* ) )
            // InternalFirstOrderLogic.g:487:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            {
            // InternalFirstOrderLogic.g:487:2: (this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )* )
            // InternalFirstOrderLogic.g:488:3: this_Or_0= ruleOr ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorAccess().getOrParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_Or_0=ruleOr();

            state._fsp--;


            			current = this_Or_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:496:3: ( () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:497:4: () otherlv_2= 'xor' ( (lv_right_3_0= ruleOr ) )
            	    {
            	    // InternalFirstOrderLogic.g:497:4: ()
            	    // InternalFirstOrderLogic.g:498:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorAccess().getXorLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getXorAccess().getXorKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:508:4: ( (lv_right_3_0= ruleOr ) )
            	    // InternalFirstOrderLogic.g:509:5: (lv_right_3_0= ruleOr )
            	    {
            	    // InternalFirstOrderLogic.g:509:5: (lv_right_3_0= ruleOr )
            	    // InternalFirstOrderLogic.g:510:6: lv_right_3_0= ruleOr
            	    {

            	    						newCompositeNode(grammarAccess.getXorAccess().getRightOrParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleOr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.Or");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXor"


    // $ANTLR start "entryRuleOr"
    // InternalFirstOrderLogic.g:532:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalFirstOrderLogic.g:532:43: (iv_ruleOr= ruleOr EOF )
            // InternalFirstOrderLogic.g:533:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalFirstOrderLogic.g:539:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:545:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalFirstOrderLogic.g:546:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalFirstOrderLogic.g:546:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalFirstOrderLogic.g:547:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:555:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:556:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalFirstOrderLogic.g:556:4: ()
            	    // InternalFirstOrderLogic.g:557:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:567:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalFirstOrderLogic.g:568:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalFirstOrderLogic.g:568:5: (lv_right_3_0= ruleAnd )
            	    // InternalFirstOrderLogic.g:569:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.And");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalFirstOrderLogic.g:591:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalFirstOrderLogic.g:591:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalFirstOrderLogic.g:592:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalFirstOrderLogic.g:598:1: ruleAnd returns [EObject current=null] : (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:604:2: ( (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) )
            // InternalFirstOrderLogic.g:605:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            {
            // InternalFirstOrderLogic.g:605:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            // InternalFirstOrderLogic.g:606:3: this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;


            			current = this_BooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalFirstOrderLogic.g:614:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalFirstOrderLogic.g:615:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) )
            	    {
            	    // InternalFirstOrderLogic.g:615:4: ()
            	    // InternalFirstOrderLogic.g:616:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalFirstOrderLogic.g:626:4: ( (lv_right_3_0= ruleBooleanExpression ) )
            	    // InternalFirstOrderLogic.g:627:5: (lv_right_3_0= ruleBooleanExpression )
            	    {
            	    // InternalFirstOrderLogic.g:627:5: (lv_right_3_0= ruleBooleanExpression )
            	    // InternalFirstOrderLogic.g:628:6: lv_right_3_0= ruleBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleBooleanExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.sidiff.validation.laguage.fol.FirstOrderLogic.BooleanExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleUnaryFormula"
    // InternalFirstOrderLogic.g:650:1: entryRuleUnaryFormula returns [EObject current=null] : iv_ruleUnaryFormula= ruleUnaryFormula EOF ;
    public final EObject entryRuleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryFormula = null;


        try {
            // InternalFirstOrderLogic.g:650:53: (iv_ruleUnaryFormula= ruleUnaryFormula EOF )
            // InternalFirstOrderLogic.g:651:2: iv_ruleUnaryFormula= ruleUnaryFormula EOF
            {
             newCompositeNode(grammarAccess.getUnaryFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryFormula=ruleUnaryFormula();

            state._fsp--;

             current =iv_ruleUnaryFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryFormula"


    // $ANTLR start "ruleUnaryFormula"
    // InternalFirstOrderLogic.g:657:1: ruleUnaryFormula returns [EObject current=null] : this_Not_0= ruleNot ;
    public final EObject ruleUnaryFormula() throws RecognitionException {
        EObject current = null;

        EObject this_Not_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:663:2: (this_Not_0= ruleNot )
            // InternalFirstOrderLogic.g:664:2: this_Not_0= ruleNot
            {

            		newCompositeNode(grammarAccess.getUnaryFormulaAccess().getNotParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Not_0=ruleNot();

            state._fsp--;


            		current = this_Not_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryFormula"


    // $ANTLR start "entryRuleNot"
    // InternalFirstOrderLogic.g:675:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // InternalFirstOrderLogic.g:675:44: (iv_ruleNot= ruleNot EOF )
            // InternalFirstOrderLogic.g:676:2: iv_ruleNot= ruleNot EOF
            {
             newCompositeNode(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNot=ruleNot();

            state._fsp--;

             current =iv_ruleNot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // InternalFirstOrderLogic.g:682:1: ruleNot returns [EObject current=null] : ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_not_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:688:2: ( ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' ) )
            // InternalFirstOrderLogic.g:689:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            {
            // InternalFirstOrderLogic.g:689:2: ( () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')' )
            // InternalFirstOrderLogic.g:690:3: () otherlv_1= 'not(' ( (lv_not_2_0= ruleFormula ) ) otherlv_3= ')'
            {
            // InternalFirstOrderLogic.g:690:3: ()
            // InternalFirstOrderLogic.g:691:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotAccess().getNotAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getNotAccess().getNotKeyword_1());
            		
            // InternalFirstOrderLogic.g:701:3: ( (lv_not_2_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:702:4: (lv_not_2_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:702:4: (lv_not_2_0= ruleFormula )
            // InternalFirstOrderLogic.g:703:5: lv_not_2_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getNotAccess().getNotFormulaParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_16);
            lv_not_2_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotRule());
            					}
            					set(
            						current,
            						"not",
            						lv_not_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNotAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRulePredicate"
    // InternalFirstOrderLogic.g:728:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // InternalFirstOrderLogic.g:728:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalFirstOrderLogic.g:729:2: iv_rulePredicate= rulePredicate EOF
            {
             newCompositeNode(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;

             current =iv_rulePredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalFirstOrderLogic.g:735:1: rulePredicate returns [EObject current=null] : (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        EObject this_Equals_0 = null;

        EObject this_Inequality_1 = null;

        EObject this_IsEmpty_2 = null;

        EObject this_IsInstanceOf_3 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:741:2: ( (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf ) )
            // InternalFirstOrderLogic.g:742:2: (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf )
            {
            // InternalFirstOrderLogic.g:742:2: (this_Equals_0= ruleEquals | this_Inequality_1= ruleInequality | this_IsEmpty_2= ruleIsEmpty | this_IsInstanceOf_3= ruleIsInstanceOf )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt7=1;
                }
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                {
                alt7=2;
                }
                break;
            case 30:
                {
                alt7=3;
                }
                break;
            case 31:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalFirstOrderLogic.g:743:3: this_Equals_0= ruleEquals
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getEqualsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Equals_0=ruleEquals();

                    state._fsp--;


                    			current = this_Equals_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:752:3: this_Inequality_1= ruleInequality
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getInequalityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Inequality_1=ruleInequality();

                    state._fsp--;


                    			current = this_Inequality_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:761:3: this_IsEmpty_2= ruleIsEmpty
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getIsEmptyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsEmpty_2=ruleIsEmpty();

                    state._fsp--;


                    			current = this_IsEmpty_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:770:3: this_IsInstanceOf_3= ruleIsInstanceOf
                    {

                    			newCompositeNode(grammarAccess.getPredicateAccess().getIsInstanceOfParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_IsInstanceOf_3=ruleIsInstanceOf();

                    state._fsp--;


                    			current = this_IsInstanceOf_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleEquals"
    // InternalFirstOrderLogic.g:782:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalFirstOrderLogic.g:782:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalFirstOrderLogic.g:783:2: iv_ruleEquals= ruleEquals EOF
            {
             newCompositeNode(grammarAccess.getEqualsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquals=ruleEquals();

            state._fsp--;

             current =iv_ruleEquals; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalFirstOrderLogic.g:789:1: ruleEquals returns [EObject current=null] : (otherlv_0= 'isEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:795:2: ( (otherlv_0= 'isEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:796:2: (otherlv_0= 'isEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:796:2: (otherlv_0= 'isEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:797:3: otherlv_0= 'isEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getEqualsAccess().getIsEqualKeyword_0());
            		
            // InternalFirstOrderLogic.g:801:3: ( (lv_left_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:802:4: (lv_left_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:802:4: (lv_left_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:803:5: lv_left_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getEqualsAccess().getLeftTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_left_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEqualsRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getEqualsAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:824:3: ( (lv_right_3_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:825:4: (lv_right_3_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:825:4: (lv_right_3_0= ruleTerm )
            // InternalFirstOrderLogic.g:826:5: lv_right_3_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getEqualsAccess().getRightTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_right_3_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEqualsRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEqualsAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleInequality"
    // InternalFirstOrderLogic.g:851:1: entryRuleInequality returns [EObject current=null] : iv_ruleInequality= ruleInequality EOF ;
    public final EObject entryRuleInequality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInequality = null;


        try {
            // InternalFirstOrderLogic.g:851:51: (iv_ruleInequality= ruleInequality EOF )
            // InternalFirstOrderLogic.g:852:2: iv_ruleInequality= ruleInequality EOF
            {
             newCompositeNode(grammarAccess.getInequalityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInequality=ruleInequality();

            state._fsp--;

             current =iv_ruleInequality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInequality"


    // $ANTLR start "ruleInequality"
    // InternalFirstOrderLogic.g:858:1: ruleInequality returns [EObject current=null] : (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual ) ;
    public final EObject ruleInequality() throws RecognitionException {
        EObject current = null;

        EObject this_Greater_0 = null;

        EObject this_GreaterEqual_1 = null;

        EObject this_Smaller_2 = null;

        EObject this_SmallerEqual_3 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:864:2: ( (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual ) )
            // InternalFirstOrderLogic.g:865:2: (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual )
            {
            // InternalFirstOrderLogic.g:865:2: (this_Greater_0= ruleGreater | this_GreaterEqual_1= ruleGreaterEqual | this_Smaller_2= ruleSmaller | this_SmallerEqual_3= ruleSmallerEqual )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt8=1;
                }
                break;
            case 27:
                {
                alt8=2;
                }
                break;
            case 28:
                {
                alt8=3;
                }
                break;
            case 29:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalFirstOrderLogic.g:866:3: this_Greater_0= ruleGreater
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getGreaterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Greater_0=ruleGreater();

                    state._fsp--;


                    			current = this_Greater_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:875:3: this_GreaterEqual_1= ruleGreaterEqual
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getGreaterEqualParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_GreaterEqual_1=ruleGreaterEqual();

                    state._fsp--;


                    			current = this_GreaterEqual_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:884:3: this_Smaller_2= ruleSmaller
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getSmallerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Smaller_2=ruleSmaller();

                    state._fsp--;


                    			current = this_Smaller_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:893:3: this_SmallerEqual_3= ruleSmallerEqual
                    {

                    			newCompositeNode(grammarAccess.getInequalityAccess().getSmallerEqualParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SmallerEqual_3=ruleSmallerEqual();

                    state._fsp--;


                    			current = this_SmallerEqual_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInequality"


    // $ANTLR start "entryRuleGreater"
    // InternalFirstOrderLogic.g:905:1: entryRuleGreater returns [EObject current=null] : iv_ruleGreater= ruleGreater EOF ;
    public final EObject entryRuleGreater() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreater = null;


        try {
            // InternalFirstOrderLogic.g:905:48: (iv_ruleGreater= ruleGreater EOF )
            // InternalFirstOrderLogic.g:906:2: iv_ruleGreater= ruleGreater EOF
            {
             newCompositeNode(grammarAccess.getGreaterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGreater=ruleGreater();

            state._fsp--;

             current =iv_ruleGreater; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGreater"


    // $ANTLR start "ruleGreater"
    // InternalFirstOrderLogic.g:912:1: ruleGreater returns [EObject current=null] : (otherlv_0= 'isGreater(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) ;
    public final EObject ruleGreater() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:918:2: ( (otherlv_0= 'isGreater(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:919:2: (otherlv_0= 'isGreater(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:919:2: (otherlv_0= 'isGreater(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:920:3: otherlv_0= 'isGreater(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterAccess().getIsGreaterKeyword_0());
            		
            // InternalFirstOrderLogic.g:924:3: ( (lv_left_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:925:4: (lv_left_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:925:4: (lv_left_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:926:5: lv_left_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterAccess().getLeftTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_left_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getGreaterAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:947:3: ( (lv_right_3_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:948:4: (lv_right_3_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:948:4: (lv_right_3_0= ruleTerm )
            // InternalFirstOrderLogic.g:949:5: lv_right_3_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterAccess().getRightTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_right_3_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGreaterAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGreater"


    // $ANTLR start "entryRuleGreaterEqual"
    // InternalFirstOrderLogic.g:974:1: entryRuleGreaterEqual returns [EObject current=null] : iv_ruleGreaterEqual= ruleGreaterEqual EOF ;
    public final EObject entryRuleGreaterEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterEqual = null;


        try {
            // InternalFirstOrderLogic.g:974:53: (iv_ruleGreaterEqual= ruleGreaterEqual EOF )
            // InternalFirstOrderLogic.g:975:2: iv_ruleGreaterEqual= ruleGreaterEqual EOF
            {
             newCompositeNode(grammarAccess.getGreaterEqualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGreaterEqual=ruleGreaterEqual();

            state._fsp--;

             current =iv_ruleGreaterEqual; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGreaterEqual"


    // $ANTLR start "ruleGreaterEqual"
    // InternalFirstOrderLogic.g:981:1: ruleGreaterEqual returns [EObject current=null] : (otherlv_0= 'isGreaterEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) ;
    public final EObject ruleGreaterEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:987:2: ( (otherlv_0= 'isGreaterEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:988:2: (otherlv_0= 'isGreaterEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:988:2: (otherlv_0= 'isGreaterEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:989:3: otherlv_0= 'isGreaterEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getGreaterEqualAccess().getIsGreaterEqualKeyword_0());
            		
            // InternalFirstOrderLogic.g:993:3: ( (lv_left_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:994:4: (lv_left_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:994:4: (lv_left_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:995:5: lv_left_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterEqualAccess().getLeftTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_left_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterEqualRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getGreaterEqualAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:1016:3: ( (lv_right_3_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1017:4: (lv_right_3_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1017:4: (lv_right_3_0= ruleTerm )
            // InternalFirstOrderLogic.g:1018:5: lv_right_3_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGreaterEqualAccess().getRightTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_right_3_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGreaterEqualRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGreaterEqualAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGreaterEqual"


    // $ANTLR start "entryRuleSmaller"
    // InternalFirstOrderLogic.g:1043:1: entryRuleSmaller returns [EObject current=null] : iv_ruleSmaller= ruleSmaller EOF ;
    public final EObject entryRuleSmaller() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmaller = null;


        try {
            // InternalFirstOrderLogic.g:1043:48: (iv_ruleSmaller= ruleSmaller EOF )
            // InternalFirstOrderLogic.g:1044:2: iv_ruleSmaller= ruleSmaller EOF
            {
             newCompositeNode(grammarAccess.getSmallerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSmaller=ruleSmaller();

            state._fsp--;

             current =iv_ruleSmaller; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSmaller"


    // $ANTLR start "ruleSmaller"
    // InternalFirstOrderLogic.g:1050:1: ruleSmaller returns [EObject current=null] : (otherlv_0= 'isSmaller(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) ;
    public final EObject ruleSmaller() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1056:2: ( (otherlv_0= 'isSmaller(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:1057:2: (otherlv_0= 'isSmaller(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:1057:2: (otherlv_0= 'isSmaller(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:1058:3: otherlv_0= 'isSmaller(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getSmallerAccess().getIsSmallerKeyword_0());
            		
            // InternalFirstOrderLogic.g:1062:3: ( (lv_left_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1063:4: (lv_left_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1063:4: (lv_left_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1064:5: lv_left_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerAccess().getLeftTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_left_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getSmallerAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:1085:3: ( (lv_right_3_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1086:4: (lv_right_3_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1086:4: (lv_right_3_0= ruleTerm )
            // InternalFirstOrderLogic.g:1087:5: lv_right_3_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerAccess().getRightTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_right_3_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSmallerAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSmaller"


    // $ANTLR start "entryRuleSmallerEqual"
    // InternalFirstOrderLogic.g:1112:1: entryRuleSmallerEqual returns [EObject current=null] : iv_ruleSmallerEqual= ruleSmallerEqual EOF ;
    public final EObject entryRuleSmallerEqual() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmallerEqual = null;


        try {
            // InternalFirstOrderLogic.g:1112:53: (iv_ruleSmallerEqual= ruleSmallerEqual EOF )
            // InternalFirstOrderLogic.g:1113:2: iv_ruleSmallerEqual= ruleSmallerEqual EOF
            {
             newCompositeNode(grammarAccess.getSmallerEqualRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSmallerEqual=ruleSmallerEqual();

            state._fsp--;

             current =iv_ruleSmallerEqual; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSmallerEqual"


    // $ANTLR start "ruleSmallerEqual"
    // InternalFirstOrderLogic.g:1119:1: ruleSmallerEqual returns [EObject current=null] : (otherlv_0= 'isSmallerEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) ;
    public final EObject ruleSmallerEqual() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1125:2: ( (otherlv_0= 'isSmallerEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:1126:2: (otherlv_0= 'isSmallerEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:1126:2: (otherlv_0= 'isSmallerEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:1127:3: otherlv_0= 'isSmallerEqual(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getSmallerEqualAccess().getIsSmallerEqualKeyword_0());
            		
            // InternalFirstOrderLogic.g:1131:3: ( (lv_left_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1132:4: (lv_left_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1132:4: (lv_left_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1133:5: lv_left_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerEqualAccess().getLeftTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_left_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerEqualRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getSmallerEqualAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:1154:3: ( (lv_right_3_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1155:4: (lv_right_3_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1155:4: (lv_right_3_0= ruleTerm )
            // InternalFirstOrderLogic.g:1156:5: lv_right_3_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSmallerEqualAccess().getRightTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_right_3_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmallerEqualRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSmallerEqualAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSmallerEqual"


    // $ANTLR start "entryRuleIsEmpty"
    // InternalFirstOrderLogic.g:1181:1: entryRuleIsEmpty returns [EObject current=null] : iv_ruleIsEmpty= ruleIsEmpty EOF ;
    public final EObject entryRuleIsEmpty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsEmpty = null;


        try {
            // InternalFirstOrderLogic.g:1181:48: (iv_ruleIsEmpty= ruleIsEmpty EOF )
            // InternalFirstOrderLogic.g:1182:2: iv_ruleIsEmpty= ruleIsEmpty EOF
            {
             newCompositeNode(grammarAccess.getIsEmptyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsEmpty=ruleIsEmpty();

            state._fsp--;

             current =iv_ruleIsEmpty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsEmpty"


    // $ANTLR start "ruleIsEmpty"
    // InternalFirstOrderLogic.g:1188:1: ruleIsEmpty returns [EObject current=null] : (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleIsEmpty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1194:2: ( (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' ) )
            // InternalFirstOrderLogic.g:1195:2: (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' )
            {
            // InternalFirstOrderLogic.g:1195:2: (otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')' )
            // InternalFirstOrderLogic.g:1196:3: otherlv_0= 'isEmpty(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getIsEmptyAccess().getIsEmptyKeyword_0());
            		
            // InternalFirstOrderLogic.g:1200:3: ( (lv_term_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1201:4: (lv_term_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1201:4: (lv_term_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1202:5: lv_term_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsEmptyAccess().getTermTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_term_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsEmptyRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getIsEmptyAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsEmpty"


    // $ANTLR start "entryRuleIsInstanceOf"
    // InternalFirstOrderLogic.g:1227:1: entryRuleIsInstanceOf returns [EObject current=null] : iv_ruleIsInstanceOf= ruleIsInstanceOf EOF ;
    public final EObject entryRuleIsInstanceOf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsInstanceOf = null;


        try {
            // InternalFirstOrderLogic.g:1227:53: (iv_ruleIsInstanceOf= ruleIsInstanceOf EOF )
            // InternalFirstOrderLogic.g:1228:2: iv_ruleIsInstanceOf= ruleIsInstanceOf EOF
            {
             newCompositeNode(grammarAccess.getIsInstanceOfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsInstanceOf=ruleIsInstanceOf();

            state._fsp--;

             current =iv_ruleIsInstanceOf; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsInstanceOf"


    // $ANTLR start "ruleIsInstanceOf"
    // InternalFirstOrderLogic.g:1234:1: ruleIsInstanceOf returns [EObject current=null] : (otherlv_0= 'isInstanceOf(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleIsInstanceOf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1240:2: ( (otherlv_0= 'isInstanceOf(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:1241:2: (otherlv_0= 'isInstanceOf(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:1241:2: (otherlv_0= 'isInstanceOf(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:1242:3: otherlv_0= 'isInstanceOf(' ( (lv_term_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getIsInstanceOfAccess().getIsInstanceOfKeyword_0());
            		
            // InternalFirstOrderLogic.g:1246:3: ( (lv_term_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1247:4: (lv_term_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1247:4: (lv_term_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1248:5: lv_term_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getIsInstanceOfAccess().getTermTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_term_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsInstanceOfRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getIsInstanceOfAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:1269:3: ( (otherlv_3= RULE_ID ) )
            // InternalFirstOrderLogic.g:1270:4: (otherlv_3= RULE_ID )
            {
            // InternalFirstOrderLogic.g:1270:4: (otherlv_3= RULE_ID )
            // InternalFirstOrderLogic.g:1271:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIsInstanceOfRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_3, grammarAccess.getIsInstanceOfAccess().getTypeEClassifierCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIsInstanceOfAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsInstanceOf"


    // $ANTLR start "entryRuleQuantifier"
    // InternalFirstOrderLogic.g:1290:1: entryRuleQuantifier returns [EObject current=null] : iv_ruleQuantifier= ruleQuantifier EOF ;
    public final EObject entryRuleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifier = null;


        try {
            // InternalFirstOrderLogic.g:1290:51: (iv_ruleQuantifier= ruleQuantifier EOF )
            // InternalFirstOrderLogic.g:1291:2: iv_ruleQuantifier= ruleQuantifier EOF
            {
             newCompositeNode(grammarAccess.getQuantifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantifier=ruleQuantifier();

            state._fsp--;

             current =iv_ruleQuantifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantifier"


    // $ANTLR start "ruleQuantifier"
    // InternalFirstOrderLogic.g:1297:1: ruleQuantifier returns [EObject current=null] : (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) ;
    public final EObject ruleQuantifier() throws RecognitionException {
        EObject current = null;

        EObject this_ForAll_0 = null;

        EObject this_Exists_1 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1303:2: ( (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists ) )
            // InternalFirstOrderLogic.g:1304:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            {
            // InternalFirstOrderLogic.g:1304:2: (this_ForAll_0= ruleForAll | this_Exists_1= ruleExists )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            else if ( (LA9_0==34) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalFirstOrderLogic.g:1305:3: this_ForAll_0= ruleForAll
                    {

                    			newCompositeNode(grammarAccess.getQuantifierAccess().getForAllParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ForAll_0=ruleForAll();

                    state._fsp--;


                    			current = this_ForAll_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1314:3: this_Exists_1= ruleExists
                    {

                    			newCompositeNode(grammarAccess.getQuantifierAccess().getExistsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Exists_1=ruleExists();

                    state._fsp--;


                    			current = this_Exists_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantifier"


    // $ANTLR start "entryRuleForAll"
    // InternalFirstOrderLogic.g:1326:1: entryRuleForAll returns [EObject current=null] : iv_ruleForAll= ruleForAll EOF ;
    public final EObject entryRuleForAll() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAll = null;


        try {
            // InternalFirstOrderLogic.g:1326:47: (iv_ruleForAll= ruleForAll EOF )
            // InternalFirstOrderLogic.g:1327:2: iv_ruleForAll= ruleForAll EOF
            {
             newCompositeNode(grammarAccess.getForAllRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForAll=ruleForAll();

            state._fsp--;

             current =iv_ruleForAll; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForAll"


    // $ANTLR start "ruleForAll"
    // InternalFirstOrderLogic.g:1333:1: ruleForAll returns [EObject current=null] : ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleForAll() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_name_2_0 = null;

        EObject lv_iteration_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1339:2: ( ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:1340:2: ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:1340:2: ( () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:1341:3: () otherlv_1= 'forAll(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:1341:3: ()
            // InternalFirstOrderLogic.g:1342:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getForAllAccess().getForAllAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getForAllAccess().getForAllKeyword_1());
            		
            // InternalFirstOrderLogic.g:1352:3: ( (lv_name_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1353:4: (lv_name_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1353:4: (lv_name_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:1354:5: lv_name_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getNameVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_name_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getForAllAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:1375:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1376:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1376:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1377:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_iteration_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getForAllAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:1398:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1399:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1399:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:1400:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getForAllAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_16);
            lv_formula_6_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForAllRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getForAllAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForAll"


    // $ANTLR start "entryRuleExists"
    // InternalFirstOrderLogic.g:1425:1: entryRuleExists returns [EObject current=null] : iv_ruleExists= ruleExists EOF ;
    public final EObject entryRuleExists() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExists = null;


        try {
            // InternalFirstOrderLogic.g:1425:47: (iv_ruleExists= ruleExists EOF )
            // InternalFirstOrderLogic.g:1426:2: iv_ruleExists= ruleExists EOF
            {
             newCompositeNode(grammarAccess.getExistsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExists=ruleExists();

            state._fsp--;

             current =iv_ruleExists; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExists"


    // $ANTLR start "ruleExists"
    // InternalFirstOrderLogic.g:1432:1: ruleExists returns [EObject current=null] : ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) ;
    public final EObject ruleExists() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_name_2_0 = null;

        EObject lv_iteration_4_0 = null;

        EObject lv_formula_6_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1438:2: ( ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' ) )
            // InternalFirstOrderLogic.g:1439:2: ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            {
            // InternalFirstOrderLogic.g:1439:2: ( () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')' )
            // InternalFirstOrderLogic.g:1440:3: () otherlv_1= 'exists(' ( (lv_name_2_0= ruleVariable ) ) otherlv_3= 'in' ( (lv_iteration_4_0= ruleTerm ) ) otherlv_5= ':' ( (lv_formula_6_0= ruleFormula ) ) otherlv_7= ')'
            {
            // InternalFirstOrderLogic.g:1440:3: ()
            // InternalFirstOrderLogic.g:1441:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExistsAccess().getExistsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getExistsAccess().getExistsKeyword_1());
            		
            // InternalFirstOrderLogic.g:1451:3: ( (lv_name_2_0= ruleVariable ) )
            // InternalFirstOrderLogic.g:1452:4: (lv_name_2_0= ruleVariable )
            {
            // InternalFirstOrderLogic.g:1452:4: (lv_name_2_0= ruleVariable )
            // InternalFirstOrderLogic.g:1453:5: lv_name_2_0= ruleVariable
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getNameVariableParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_name_2_0=ruleVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Variable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_17); 

            			newLeafNode(otherlv_3, grammarAccess.getExistsAccess().getInKeyword_3());
            		
            // InternalFirstOrderLogic.g:1474:3: ( (lv_iteration_4_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1475:4: (lv_iteration_4_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1475:4: (lv_iteration_4_0= ruleTerm )
            // InternalFirstOrderLogic.g:1476:5: lv_iteration_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getIterationTermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_9);
            lv_iteration_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"iteration",
            						lv_iteration_4_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getExistsAccess().getColonKeyword_5());
            		
            // InternalFirstOrderLogic.g:1497:3: ( (lv_formula_6_0= ruleFormula ) )
            // InternalFirstOrderLogic.g:1498:4: (lv_formula_6_0= ruleFormula )
            {
            // InternalFirstOrderLogic.g:1498:4: (lv_formula_6_0= ruleFormula )
            // InternalFirstOrderLogic.g:1499:5: lv_formula_6_0= ruleFormula
            {

            					newCompositeNode(grammarAccess.getExistsAccess().getFormulaFormulaParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_16);
            lv_formula_6_0=ruleFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExistsRule());
            					}
            					set(
            						current,
            						"formula",
            						lv_formula_6_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Formula");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getExistsAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExists"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalFirstOrderLogic.g:1524:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalFirstOrderLogic.g:1524:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalFirstOrderLogic.g:1525:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;

             current =iv_ruleBooleanExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalFirstOrderLogic.g:1531:1: ruleBooleanExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Formula_1 = null;

        EObject this_UnaryFormula_3 = null;

        EObject this_Quantifier_4 = null;

        EObject this_Predicate_5 = null;

        EObject this_BoolConstant_6 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1537:2: ( ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant ) )
            // InternalFirstOrderLogic.g:1538:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant )
            {
            // InternalFirstOrderLogic.g:1538:2: ( (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' ) | this_UnaryFormula_3= ruleUnaryFormula | this_Quantifier_4= ruleQuantifier | this_Predicate_5= rulePredicate | this_BoolConstant_6= ruleBoolConstant )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt10=1;
                }
                break;
            case 22:
                {
                alt10=2;
                }
                break;
            case 32:
            case 34:
                {
                alt10=3;
                }
                break;
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt10=4;
                }
                break;
            case 36:
            case 37:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalFirstOrderLogic.g:1539:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    {
                    // InternalFirstOrderLogic.g:1539:3: (otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')' )
                    // InternalFirstOrderLogic.g:1540:4: otherlv_0= '(' this_Formula_1= ruleFormula otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,35,FOLLOW_10); 

                    				newLeafNode(otherlv_0, grammarAccess.getBooleanExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getBooleanExpressionAccess().getFormulaParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_16);
                    this_Formula_1=ruleFormula();

                    state._fsp--;


                    				current = this_Formula_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,23,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1558:3: this_UnaryFormula_3= ruleUnaryFormula
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getUnaryFormulaParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryFormula_3=ruleUnaryFormula();

                    state._fsp--;


                    			current = this_UnaryFormula_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1567:3: this_Quantifier_4= ruleQuantifier
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getQuantifierParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Quantifier_4=ruleQuantifier();

                    state._fsp--;


                    			current = this_Quantifier_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1576:3: this_Predicate_5= rulePredicate
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getPredicateParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Predicate_5=rulePredicate();

                    state._fsp--;


                    			current = this_Predicate_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1585:3: this_BoolConstant_6= ruleBoolConstant
                    {

                    			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getBoolConstantParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolConstant_6=ruleBoolConstant();

                    state._fsp--;


                    			current = this_BoolConstant_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleBoolConstant"
    // InternalFirstOrderLogic.g:1597:1: entryRuleBoolConstant returns [EObject current=null] : iv_ruleBoolConstant= ruleBoolConstant EOF ;
    public final EObject entryRuleBoolConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolConstant = null;


        try {
            // InternalFirstOrderLogic.g:1597:53: (iv_ruleBoolConstant= ruleBoolConstant EOF )
            // InternalFirstOrderLogic.g:1598:2: iv_ruleBoolConstant= ruleBoolConstant EOF
            {
             newCompositeNode(grammarAccess.getBoolConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolConstant=ruleBoolConstant();

            state._fsp--;

             current =iv_ruleBoolConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolConstant"


    // $ANTLR start "ruleBoolConstant"
    // InternalFirstOrderLogic.g:1604:1: ruleBoolConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) ) ;
    public final EObject ruleBoolConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;


        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1610:2: ( ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) ) )
            // InternalFirstOrderLogic.g:1611:2: ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) )
            {
            // InternalFirstOrderLogic.g:1611:2: ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) )
            // InternalFirstOrderLogic.g:1612:3: () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) )
            {
            // InternalFirstOrderLogic.g:1612:3: ()
            // InternalFirstOrderLogic.g:1613:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolConstantAccess().getBoolConstantAction_0(),
            					current);
            			

            }

            // InternalFirstOrderLogic.g:1619:3: ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) )
            // InternalFirstOrderLogic.g:1620:4: ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) )
            {
            // InternalFirstOrderLogic.g:1620:4: ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) )
            // InternalFirstOrderLogic.g:1621:5: (lv_value_1_1= 'true' | lv_value_1_2= 'false' )
            {
            // InternalFirstOrderLogic.g:1621:5: (lv_value_1_1= 'true' | lv_value_1_2= 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==36) ) {
                alt11=1;
            }
            else if ( (LA11_0==37) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalFirstOrderLogic.g:1622:6: lv_value_1_1= 'true'
                    {
                    lv_value_1_1=(Token)match(input,36,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getBoolConstantAccess().getValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBoolConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1633:6: lv_value_1_2= 'false'
                    {
                    lv_value_1_2=(Token)match(input,37,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getBoolConstantAccess().getValueFalseKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBoolConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_2, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolConstant"


    // $ANTLR start "entryRuleTerm"
    // InternalFirstOrderLogic.g:1650:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalFirstOrderLogic.g:1650:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalFirstOrderLogic.g:1651:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalFirstOrderLogic.g:1657:1: ruleTerm returns [EObject current=null] : (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_Concatenate_6= ruleConcatenate | this_Capitalize_7= ruleCapitalize ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_VariableRef_1 = null;

        EObject this_GetContainments_2 = null;

        EObject this_GetContainer_3 = null;

        EObject this_GetClosure_4 = null;

        EObject this_Size_5 = null;

        EObject this_Concatenate_6 = null;

        EObject this_Capitalize_7 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1663:2: ( (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_Concatenate_6= ruleConcatenate | this_Capitalize_7= ruleCapitalize ) )
            // InternalFirstOrderLogic.g:1664:2: (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_Concatenate_6= ruleConcatenate | this_Capitalize_7= ruleCapitalize )
            {
            // InternalFirstOrderLogic.g:1664:2: (this_Constant_0= ruleConstant | this_VariableRef_1= ruleVariableRef | this_GetContainments_2= ruleGetContainments | this_GetContainer_3= ruleGetContainer | this_GetClosure_4= ruleGetClosure | this_Size_5= ruleSize | this_Concatenate_6= ruleConcatenate | this_Capitalize_7= ruleCapitalize )
            int alt12=8;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case 36:
            case 37:
                {
                alt12=1;
                }
                break;
            case RULE_ID:
                {
                alt12=2;
                }
                break;
            case 41:
                {
                alt12=3;
                }
                break;
            case 40:
                {
                alt12=4;
                }
                break;
            case 42:
                {
                alt12=5;
                }
                break;
            case 43:
                {
                alt12=6;
                }
                break;
            case 44:
                {
                alt12=7;
                }
                break;
            case 45:
                {
                alt12=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalFirstOrderLogic.g:1665:3: this_Constant_0= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getConstantParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_0=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:1674:3: this_VariableRef_1= ruleVariableRef
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getVariableRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableRef_1=ruleVariableRef();

                    state._fsp--;


                    			current = this_VariableRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:1683:3: this_GetContainments_2= ruleGetContainments
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getGetContainmentsParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetContainments_2=ruleGetContainments();

                    state._fsp--;


                    			current = this_GetContainments_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFirstOrderLogic.g:1692:3: this_GetContainer_3= ruleGetContainer
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getGetContainerParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetContainer_3=ruleGetContainer();

                    state._fsp--;


                    			current = this_GetContainer_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFirstOrderLogic.g:1701:3: this_GetClosure_4= ruleGetClosure
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getGetClosureParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetClosure_4=ruleGetClosure();

                    state._fsp--;


                    			current = this_GetClosure_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalFirstOrderLogic.g:1710:3: this_Size_5= ruleSize
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getSizeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Size_5=ruleSize();

                    state._fsp--;


                    			current = this_Size_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalFirstOrderLogic.g:1719:3: this_Concatenate_6= ruleConcatenate
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getConcatenateParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Concatenate_6=ruleConcatenate();

                    state._fsp--;


                    			current = this_Concatenate_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalFirstOrderLogic.g:1728:3: this_Capitalize_7= ruleCapitalize
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getCapitalizeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Capitalize_7=ruleCapitalize();

                    state._fsp--;


                    			current = this_Capitalize_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleVariableRef"
    // InternalFirstOrderLogic.g:1740:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalFirstOrderLogic.g:1740:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalFirstOrderLogic.g:1741:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalFirstOrderLogic.g:1747:1: ruleVariableRef returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_get_2_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1753:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:1754:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:1754:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:1755:3: () ( (otherlv_1= RULE_ID ) ) ( (lv_get_2_0= ruleGet ) )?
            {
            // InternalFirstOrderLogic.g:1755:3: ()
            // InternalFirstOrderLogic.g:1756:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
            					current);
            			

            }

            // InternalFirstOrderLogic.g:1762:3: ( (otherlv_1= RULE_ID ) )
            // InternalFirstOrderLogic.g:1763:4: (otherlv_1= RULE_ID )
            {
            // InternalFirstOrderLogic.g:1763:4: (otherlv_1= RULE_ID )
            // InternalFirstOrderLogic.g:1764:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRefRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(otherlv_1, grammarAccess.getVariableRefAccess().getNameVariableCrossReference_1_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:1775:3: ( (lv_get_2_0= ruleGet ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalFirstOrderLogic.g:1776:4: (lv_get_2_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:1776:4: (lv_get_2_0= ruleGet )
                    // InternalFirstOrderLogic.g:1777:5: lv_get_2_0= ruleGet
                    {

                    					newCompositeNode(grammarAccess.getVariableRefAccess().getGetGetParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_get_2_0=ruleGet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getVariableRefRule());
                    					}
                    					set(
                    						current,
                    						"get",
                    						lv_get_2_0,
                    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Get");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleGet"
    // InternalFirstOrderLogic.g:1798:1: entryRuleGet returns [EObject current=null] : iv_ruleGet= ruleGet EOF ;
    public final EObject entryRuleGet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGet = null;


        try {
            // InternalFirstOrderLogic.g:1798:44: (iv_ruleGet= ruleGet EOF )
            // InternalFirstOrderLogic.g:1799:2: iv_ruleGet= ruleGet EOF
            {
             newCompositeNode(grammarAccess.getGetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGet=ruleGet();

            state._fsp--;

             current =iv_ruleGet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGet"


    // $ANTLR start "ruleGet"
    // InternalFirstOrderLogic.g:1805:1: ruleGet returns [EObject current=null] : (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? ) ;
    public final EObject ruleGet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_next_4_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1811:2: ( (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? ) )
            // InternalFirstOrderLogic.g:1812:2: (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? )
            {
            // InternalFirstOrderLogic.g:1812:2: (otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )? )
            // InternalFirstOrderLogic.g:1813:3: otherlv_0= '.' ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )? ( (otherlv_3= RULE_ID ) ) ( (lv_next_4_0= ruleGet ) )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGetAccess().getFullStopKeyword_0());
            		
            // InternalFirstOrderLogic.g:1817:3: ( ( (otherlv_1= RULE_ID ) ) otherlv_2= '::' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==39) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalFirstOrderLogic.g:1818:4: ( (otherlv_1= RULE_ID ) ) otherlv_2= '::'
                    {
                    // InternalFirstOrderLogic.g:1818:4: ( (otherlv_1= RULE_ID ) )
                    // InternalFirstOrderLogic.g:1819:5: (otherlv_1= RULE_ID )
                    {
                    // InternalFirstOrderLogic.g:1819:5: (otherlv_1= RULE_ID )
                    // InternalFirstOrderLogic.g:1820:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGetRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_21); 

                    						newLeafNode(otherlv_1, grammarAccess.getGetAccess().getTypeEClassifierCrossReference_1_0_0());
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getGetAccess().getColonColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalFirstOrderLogic.g:1836:3: ( (otherlv_3= RULE_ID ) )
            // InternalFirstOrderLogic.g:1837:4: (otherlv_3= RULE_ID )
            {
            // InternalFirstOrderLogic.g:1837:4: (otherlv_3= RULE_ID )
            // InternalFirstOrderLogic.g:1838:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(otherlv_3, grammarAccess.getGetAccess().getNameEStructuralFeatureCrossReference_2_0());
            				

            }


            }

            // InternalFirstOrderLogic.g:1849:3: ( (lv_next_4_0= ruleGet ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==38) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFirstOrderLogic.g:1850:4: (lv_next_4_0= ruleGet )
                    {
                    // InternalFirstOrderLogic.g:1850:4: (lv_next_4_0= ruleGet )
                    // InternalFirstOrderLogic.g:1851:5: lv_next_4_0= ruleGet
                    {

                    					newCompositeNode(grammarAccess.getGetAccess().getNextGetParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_next_4_0=ruleGet();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getGetRule());
                    					}
                    					set(
                    						current,
                    						"next",
                    						lv_next_4_0,
                    						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Get");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGet"


    // $ANTLR start "entryRuleGetContainer"
    // InternalFirstOrderLogic.g:1872:1: entryRuleGetContainer returns [EObject current=null] : iv_ruleGetContainer= ruleGetContainer EOF ;
    public final EObject entryRuleGetContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetContainer = null;


        try {
            // InternalFirstOrderLogic.g:1872:53: (iv_ruleGetContainer= ruleGetContainer EOF )
            // InternalFirstOrderLogic.g:1873:2: iv_ruleGetContainer= ruleGetContainer EOF
            {
             newCompositeNode(grammarAccess.getGetContainerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetContainer=ruleGetContainer();

            state._fsp--;

             current =iv_ruleGetContainer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetContainer"


    // $ANTLR start "ruleGetContainer"
    // InternalFirstOrderLogic.g:1879:1: ruleGetContainer returns [EObject current=null] : (otherlv_0= 'getContainer(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleGetContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_element_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1885:2: ( (otherlv_0= 'getContainer(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' ) )
            // InternalFirstOrderLogic.g:1886:2: (otherlv_0= 'getContainer(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' )
            {
            // InternalFirstOrderLogic.g:1886:2: (otherlv_0= 'getContainer(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' )
            // InternalFirstOrderLogic.g:1887:3: otherlv_0= 'getContainer(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getGetContainerAccess().getGetContainerKeyword_0());
            		
            // InternalFirstOrderLogic.g:1891:3: ( (lv_element_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1892:4: (lv_element_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1892:4: (lv_element_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1893:5: lv_element_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetContainerAccess().getElementTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_element_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetContainerRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getGetContainerAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetContainer"


    // $ANTLR start "entryRuleGetContainments"
    // InternalFirstOrderLogic.g:1918:1: entryRuleGetContainments returns [EObject current=null] : iv_ruleGetContainments= ruleGetContainments EOF ;
    public final EObject entryRuleGetContainments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetContainments = null;


        try {
            // InternalFirstOrderLogic.g:1918:56: (iv_ruleGetContainments= ruleGetContainments EOF )
            // InternalFirstOrderLogic.g:1919:2: iv_ruleGetContainments= ruleGetContainments EOF
            {
             newCompositeNode(grammarAccess.getGetContainmentsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetContainments=ruleGetContainments();

            state._fsp--;

             current =iv_ruleGetContainments; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetContainments"


    // $ANTLR start "ruleGetContainments"
    // InternalFirstOrderLogic.g:1925:1: ruleGetContainments returns [EObject current=null] : (otherlv_0= 'getContainments(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleGetContainments() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_element_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1931:2: ( (otherlv_0= 'getContainments(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' ) )
            // InternalFirstOrderLogic.g:1932:2: (otherlv_0= 'getContainments(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' )
            {
            // InternalFirstOrderLogic.g:1932:2: (otherlv_0= 'getContainments(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')' )
            // InternalFirstOrderLogic.g:1933:3: otherlv_0= 'getContainments(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getGetContainmentsAccess().getGetContainmentsKeyword_0());
            		
            // InternalFirstOrderLogic.g:1937:3: ( (lv_element_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1938:4: (lv_element_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1938:4: (lv_element_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1939:5: lv_element_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetContainmentsAccess().getElementTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_element_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetContainmentsRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getGetContainmentsAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetContainments"


    // $ANTLR start "entryRuleGetClosure"
    // InternalFirstOrderLogic.g:1964:1: entryRuleGetClosure returns [EObject current=null] : iv_ruleGetClosure= ruleGetClosure EOF ;
    public final EObject entryRuleGetClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetClosure = null;


        try {
            // InternalFirstOrderLogic.g:1964:51: (iv_ruleGetClosure= ruleGetClosure EOF )
            // InternalFirstOrderLogic.g:1965:2: iv_ruleGetClosure= ruleGetClosure EOF
            {
             newCompositeNode(grammarAccess.getGetClosureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetClosure=ruleGetClosure();

            state._fsp--;

             current =iv_ruleGetClosure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetClosure"


    // $ANTLR start "ruleGetClosure"
    // InternalFirstOrderLogic.g:1971:1: ruleGetClosure returns [EObject current=null] : (otherlv_0= 'getClosure(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleGetClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_element_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:1977:2: ( (otherlv_0= 'getClosure(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:1978:2: (otherlv_0= 'getClosure(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:1978:2: (otherlv_0= 'getClosure(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:1979:3: otherlv_0= 'getClosure(' ( (lv_element_1_0= ruleTerm ) ) otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getGetClosureAccess().getGetClosureKeyword_0());
            		
            // InternalFirstOrderLogic.g:1983:3: ( (lv_element_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:1984:4: (lv_element_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:1984:4: (lv_element_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:1985:5: lv_element_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getGetClosureAccess().getElementTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_element_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClosureRule());
            					}
            					set(
            						current,
            						"element",
            						lv_element_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getGetClosureAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:2006:3: ( (otherlv_3= RULE_ID ) )
            // InternalFirstOrderLogic.g:2007:4: (otherlv_3= RULE_ID )
            {
            // InternalFirstOrderLogic.g:2007:4: (otherlv_3= RULE_ID )
            // InternalFirstOrderLogic.g:2008:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetClosureRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_3, grammarAccess.getGetClosureAccess().getFeatureEStructuralFeatureCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGetClosureAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetClosure"


    // $ANTLR start "entryRuleSize"
    // InternalFirstOrderLogic.g:2027:1: entryRuleSize returns [EObject current=null] : iv_ruleSize= ruleSize EOF ;
    public final EObject entryRuleSize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSize = null;


        try {
            // InternalFirstOrderLogic.g:2027:45: (iv_ruleSize= ruleSize EOF )
            // InternalFirstOrderLogic.g:2028:2: iv_ruleSize= ruleSize EOF
            {
             newCompositeNode(grammarAccess.getSizeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSize=ruleSize();

            state._fsp--;

             current =iv_ruleSize; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSize"


    // $ANTLR start "ruleSize"
    // InternalFirstOrderLogic.g:2034:1: ruleSize returns [EObject current=null] : (otherlv_0= 'size(' ( (lv_elements_1_0= ruleTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleSize() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2040:2: ( (otherlv_0= 'size(' ( (lv_elements_1_0= ruleTerm ) ) otherlv_2= ')' ) )
            // InternalFirstOrderLogic.g:2041:2: (otherlv_0= 'size(' ( (lv_elements_1_0= ruleTerm ) ) otherlv_2= ')' )
            {
            // InternalFirstOrderLogic.g:2041:2: (otherlv_0= 'size(' ( (lv_elements_1_0= ruleTerm ) ) otherlv_2= ')' )
            // InternalFirstOrderLogic.g:2042:3: otherlv_0= 'size(' ( (lv_elements_1_0= ruleTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getSizeAccess().getSizeKeyword_0());
            		
            // InternalFirstOrderLogic.g:2046:3: ( (lv_elements_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2047:4: (lv_elements_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2047:4: (lv_elements_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:2048:5: lv_elements_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getSizeAccess().getElementsTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_elements_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSizeRule());
            					}
            					set(
            						current,
            						"elements",
            						lv_elements_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getSizeAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSize"


    // $ANTLR start "entryRuleConcatenate"
    // InternalFirstOrderLogic.g:2073:1: entryRuleConcatenate returns [EObject current=null] : iv_ruleConcatenate= ruleConcatenate EOF ;
    public final EObject entryRuleConcatenate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenate = null;


        try {
            // InternalFirstOrderLogic.g:2073:52: (iv_ruleConcatenate= ruleConcatenate EOF )
            // InternalFirstOrderLogic.g:2074:2: iv_ruleConcatenate= ruleConcatenate EOF
            {
             newCompositeNode(grammarAccess.getConcatenateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcatenate=ruleConcatenate();

            state._fsp--;

             current =iv_ruleConcatenate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatenate"


    // $ANTLR start "ruleConcatenate"
    // InternalFirstOrderLogic.g:2080:1: ruleConcatenate returns [EObject current=null] : (otherlv_0= 'concatenate(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) ;
    public final EObject ruleConcatenate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2086:2: ( (otherlv_0= 'concatenate(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' ) )
            // InternalFirstOrderLogic.g:2087:2: (otherlv_0= 'concatenate(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            {
            // InternalFirstOrderLogic.g:2087:2: (otherlv_0= 'concatenate(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')' )
            // InternalFirstOrderLogic.g:2088:3: otherlv_0= 'concatenate(' ( (lv_left_1_0= ruleTerm ) ) otherlv_2= ',' ( (lv_right_3_0= ruleTerm ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getConcatenateAccess().getConcatenateKeyword_0());
            		
            // InternalFirstOrderLogic.g:2092:3: ( (lv_left_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2093:4: (lv_left_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2093:4: (lv_left_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:2094:5: lv_left_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getConcatenateAccess().getLeftTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_left_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcatenateRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getConcatenateAccess().getCommaKeyword_2());
            		
            // InternalFirstOrderLogic.g:2115:3: ( (lv_right_3_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2116:4: (lv_right_3_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2116:4: (lv_right_3_0= ruleTerm )
            // InternalFirstOrderLogic.g:2117:5: lv_right_3_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getConcatenateAccess().getRightTermParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_right_3_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcatenateRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConcatenateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatenate"


    // $ANTLR start "entryRuleCapitalize"
    // InternalFirstOrderLogic.g:2142:1: entryRuleCapitalize returns [EObject current=null] : iv_ruleCapitalize= ruleCapitalize EOF ;
    public final EObject entryRuleCapitalize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapitalize = null;


        try {
            // InternalFirstOrderLogic.g:2142:51: (iv_ruleCapitalize= ruleCapitalize EOF )
            // InternalFirstOrderLogic.g:2143:2: iv_ruleCapitalize= ruleCapitalize EOF
            {
             newCompositeNode(grammarAccess.getCapitalizeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCapitalize=ruleCapitalize();

            state._fsp--;

             current =iv_ruleCapitalize; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCapitalize"


    // $ANTLR start "ruleCapitalize"
    // InternalFirstOrderLogic.g:2149:1: ruleCapitalize returns [EObject current=null] : (otherlv_0= 'capitalize(' ( (lv_string_1_0= ruleTerm ) ) otherlv_2= ')' ) ;
    public final EObject ruleCapitalize() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_string_1_0 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2155:2: ( (otherlv_0= 'capitalize(' ( (lv_string_1_0= ruleTerm ) ) otherlv_2= ')' ) )
            // InternalFirstOrderLogic.g:2156:2: (otherlv_0= 'capitalize(' ( (lv_string_1_0= ruleTerm ) ) otherlv_2= ')' )
            {
            // InternalFirstOrderLogic.g:2156:2: (otherlv_0= 'capitalize(' ( (lv_string_1_0= ruleTerm ) ) otherlv_2= ')' )
            // InternalFirstOrderLogic.g:2157:3: otherlv_0= 'capitalize(' ( (lv_string_1_0= ruleTerm ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getCapitalizeAccess().getCapitalizeKeyword_0());
            		
            // InternalFirstOrderLogic.g:2161:3: ( (lv_string_1_0= ruleTerm ) )
            // InternalFirstOrderLogic.g:2162:4: (lv_string_1_0= ruleTerm )
            {
            // InternalFirstOrderLogic.g:2162:4: (lv_string_1_0= ruleTerm )
            // InternalFirstOrderLogic.g:2163:5: lv_string_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getCapitalizeAccess().getStringTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_string_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCapitalizeRule());
            					}
            					set(
            						current,
            						"string",
            						lv_string_1_0,
            						"org.sidiff.validation.laguage.fol.FirstOrderLogic.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getCapitalizeAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCapitalize"


    // $ANTLR start "entryRuleConstant"
    // InternalFirstOrderLogic.g:2188:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalFirstOrderLogic.g:2188:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalFirstOrderLogic.g:2189:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalFirstOrderLogic.g:2195:1: ruleConstant returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | this_BoolConstant_4= ruleBoolConstant ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        EObject this_BoolConstant_4 = null;



        	enterRule();

        try {
            // InternalFirstOrderLogic.g:2201:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | this_BoolConstant_4= ruleBoolConstant ) )
            // InternalFirstOrderLogic.g:2202:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | this_BoolConstant_4= ruleBoolConstant )
            {
            // InternalFirstOrderLogic.g:2202:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | this_BoolConstant_4= ruleBoolConstant )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt16=1;
                }
                break;
            case RULE_STRING:
                {
                alt16=2;
                }
                break;
            case 36:
            case 37:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalFirstOrderLogic.g:2203:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalFirstOrderLogic.g:2203:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalFirstOrderLogic.g:2204:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalFirstOrderLogic.g:2204:4: ()
                    // InternalFirstOrderLogic.g:2205:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getIntConstantAction_0_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:2211:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalFirstOrderLogic.g:2212:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalFirstOrderLogic.g:2212:5: (lv_value_1_0= RULE_INT )
                    // InternalFirstOrderLogic.g:2213:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFirstOrderLogic.g:2231:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalFirstOrderLogic.g:2231:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalFirstOrderLogic.g:2232:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalFirstOrderLogic.g:2232:4: ()
                    // InternalFirstOrderLogic.g:2233:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConstantAccess().getStringConstantAction_1_0(),
                    						current);
                    				

                    }

                    // InternalFirstOrderLogic.g:2239:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalFirstOrderLogic.g:2240:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalFirstOrderLogic.g:2240:5: (lv_value_3_0= RULE_STRING )
                    // InternalFirstOrderLogic.g:2241:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getConstantAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFirstOrderLogic.g:2259:3: this_BoolConstant_4= ruleBoolConstant
                    {

                    			newCompositeNode(grammarAccess.getConstantAccess().getBoolConstantParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoolConstant_4=ruleBoolConstant();

                    state._fsp--;


                    			current = this_BoolConstant_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000003DFD400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00003F3DFD400070L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000008000000000L});

}