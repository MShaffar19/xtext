/*
 * generated by Xtext
 */
grammar PsiInternalReferenceGrammarTestLanguage;

options {
	superClass=AbstractPsiAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;
}

@parser::members {

	protected ReferenceGrammarTestLanguageGrammarAccess grammarAccess;

	protected ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider;

	public PsiInternalReferenceGrammarTestLanguageParser(PsiBuilder builder, TokenStream input, ReferenceGrammarTestLanguageElementTypeProvider elementTypeProvider, ReferenceGrammarTestLanguageGrammarAccess grammarAccess) {
		this(input);
		setPsiBuilder(builder);
    	this.grammarAccess = grammarAccess;
		this.elementTypeProvider = elementTypeProvider;
	}

	@Override
	protected String getFirstRuleName() {
		return "Spielplatz";
	}

}

//Entry rule entryRuleSpielplatz
entryRuleSpielplatz:
	{ markComposite(elementTypeProvider.getSpielplatzElementType()); }
	ruleSpielplatz
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Spielplatz
ruleSpielplatz:
	(
		{
			markLeaf();
		}
		otherlv_0='spielplatz'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getSpielplatz_SpielplatzKeyword_0ElementType());
		}
		(
			(
				{
					markLeaf();
				}
				lv_groesse_1_0=RULE_INT
				{
					doneLeaf(lv_groesse_1_0, elementTypeProvider.getSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType());
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				lv_beschreibung_2_0=RULE_STRING
				{
					doneLeaf(lv_beschreibung_2_0, elementTypeProvider.getSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType());
				}
			)
		)?
		{
			markLeaf();
		}
		otherlv_3='{'
		{
			doneLeaf(otherlv_3, elementTypeProvider.getSpielplatz_LeftCurlyBracketKeyword_3ElementType());
		}
		(
			(
				(
					{
						markComposite(elementTypeProvider.getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType());
					}
					lv_kinder_4_0=ruleKind
					{
						doneComposite();
					}
				)
			)
			    |
			(
				(
					{
						markComposite(elementTypeProvider.getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType());
					}
					lv_erzieher_5_0=ruleErwachsener
					{
						doneComposite();
					}
				)
			)
			    |
			(
				(
					{
						markComposite(elementTypeProvider.getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType());
					}
					lv_spielzeuge_6_0=ruleSpielzeug
					{
						doneComposite();
					}
				)
			)
			    |
			(
				(
					{
						markComposite(elementTypeProvider.getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType());
					}
					lv_familie_7_0=ruleFamilie
					{
						doneComposite();
					}
				)
			)
		)*
		{
			markLeaf();
		}
		otherlv_8='}'
		{
			doneLeaf(otherlv_8, elementTypeProvider.getSpielplatz_RightCurlyBracketKeyword_5ElementType());
		}
	)?
;

//Entry rule entryRuleKind
entryRuleKind:
	{ markComposite(elementTypeProvider.getKindElementType()); }
	ruleKind
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Kind
ruleKind:
	(
		{
			markLeaf();
		}
		otherlv_0='kind'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getKind_KindKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='('
		{
			doneLeaf(otherlv_1, elementTypeProvider.getKind_LeftParenthesisKeyword_1ElementType());
		}
		(
			(
				{
					markLeaf();
				}
				lv_name_2_0=RULE_ID
				{
					doneLeaf(lv_name_2_0, elementTypeProvider.getKind_NameIDTerminalRuleCall_2_0ElementType());
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				lv_age_3_0=RULE_INT
				{
					doneLeaf(lv_age_3_0, elementTypeProvider.getKind_AgeINTTerminalRuleCall_3_0ElementType());
				}
			)
		)
		{
			markLeaf();
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4, elementTypeProvider.getKind_RightParenthesisKeyword_4ElementType());
		}
	)
;

//Entry rule entryRuleErwachsener
entryRuleErwachsener:
	{ markComposite(elementTypeProvider.getErwachsenerElementType()); }
	ruleErwachsener
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Erwachsener
ruleErwachsener:
	(
		{
			markLeaf();
		}
		otherlv_0='erwachsener'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getErwachsener_ErwachsenerKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='('
		{
			doneLeaf(otherlv_1, elementTypeProvider.getErwachsener_LeftParenthesisKeyword_1ElementType());
		}
		(
			(
				{
					markLeaf();
				}
				lv_name_2_0=RULE_ID
				{
					doneLeaf(lv_name_2_0, elementTypeProvider.getErwachsener_NameIDTerminalRuleCall_2_0ElementType());
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				lv_age_3_0=RULE_INT
				{
					doneLeaf(lv_age_3_0, elementTypeProvider.getErwachsener_AgeINTTerminalRuleCall_3_0ElementType());
				}
			)
		)
		{
			markLeaf();
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4, elementTypeProvider.getErwachsener_RightParenthesisKeyword_4ElementType());
		}
	)
;

//Entry rule entryRuleSpielzeug
entryRuleSpielzeug:
	{ markComposite(elementTypeProvider.getSpielzeugElementType()); }
	ruleSpielzeug
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Spielzeug
ruleSpielzeug:
	(
		{
			markLeaf();
		}
		otherlv_0='spielzeug'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getSpielzeug_SpielzeugKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='('
		{
			doneLeaf(otherlv_1, elementTypeProvider.getSpielzeug_LeftParenthesisKeyword_1ElementType());
		}
		(
			(
				{
					markLeaf();
				}
				lv_name_2_0=RULE_ID
				{
					doneLeaf(lv_name_2_0, elementTypeProvider.getSpielzeug_NameIDTerminalRuleCall_2_0ElementType());
				}
			)
		)
		(
			(
				{
					markComposite(elementTypeProvider.getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType());
				}
				lv_farbe_3_0=ruleFarbe
				{
					doneComposite();
				}
			)
		)
		{
			markLeaf();
		}
		otherlv_4=')'
		{
			doneLeaf(otherlv_4, elementTypeProvider.getSpielzeug_RightParenthesisKeyword_4ElementType());
		}
	)
;

//Entry rule entryRuleFarbe
entryRuleFarbe:
	{ markComposite(elementTypeProvider.getFarbeElementType()); }
	ruleFarbe
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Farbe
ruleFarbe:
	(
		(
			(
				{
					markLeaf();
				}
				lv_wert_0_1='ROT'
				{
					doneLeaf(lv_wert_0_1, elementTypeProvider.getFarbe_WertROTKeyword_0_0ElementType());
				}
				    |
				{
					markLeaf();
				}
				lv_wert_0_2='BLAU'
				{
					doneLeaf(lv_wert_0_2, elementTypeProvider.getFarbe_WertBLAUKeyword_0_1ElementType());
				}
				    |
				{
					markLeaf();
				}
				lv_wert_0_3='GELB'
				{
					doneLeaf(lv_wert_0_3, elementTypeProvider.getFarbe_WertGELBKeyword_0_2ElementType());
				}
				    |
				{
					markLeaf();
				}
				lv_wert_0_4='GR\u00DCN'
				{
					doneLeaf(lv_wert_0_4, elementTypeProvider.getFarbe_WertGR�NKeyword_0_3ElementType());
				}
			)
		)
	)
;

//Entry rule entryRuleFamilie
entryRuleFamilie:
	{ markComposite(elementTypeProvider.getFamilieElementType()); }
	ruleFamilie
	{ doneComposite(); }
	EOF;
finally {
}

// Rule Familie
ruleFamilie:
	(
		{
			markLeaf();
		}
		otherlv_0='familie'
		{
			doneLeaf(otherlv_0, elementTypeProvider.getFamilie_FamilieKeyword_0ElementType());
		}
		{
			markLeaf();
		}
		otherlv_1='('
		{
			doneLeaf(otherlv_1, elementTypeProvider.getFamilie_LeftParenthesisKeyword_1ElementType());
		}
		(
			(
				(
					{
						markLeaf();
					}
					lv_name_2_1='keyword'
					{
						doneLeaf(lv_name_2_1, elementTypeProvider.getFamilie_NameKeywordKeyword_2_0_0ElementType());
					}
					    |
					{
						markLeaf();
					}
					lv_name_2_2=RULE_STRING
					{
						doneLeaf(lv_name_2_2, elementTypeProvider.getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType());
					}
					    |
					{
						markLeaf();
					}
					lv_name_2_3=RULE_ID
					{
						doneLeaf(lv_name_2_3, elementTypeProvider.getFamilie_NameIDTerminalRuleCall_2_0_2ElementType());
					}
				)
			)
		)
		(
			(
				{
					markLeaf();
				}
				otherlv_3=RULE_ID
				{
					doneLeaf(otherlv_3, elementTypeProvider.getFamilie_MutterErwachsenerCrossReference_3_0ElementType());
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				otherlv_4=RULE_ID
				{
					doneLeaf(otherlv_4, elementTypeProvider.getFamilie_VaterErwachsenerCrossReference_4_0ElementType());
				}
			)
		)
		(
			(
				{
					markLeaf();
				}
				otherlv_5=RULE_ID
				{
					doneLeaf(otherlv_5, elementTypeProvider.getFamilie_KinderKindCrossReference_5_0ElementType());
				}
			)
		)
		(
			{
				markLeaf();
			}
			otherlv_6=','
			{
				doneLeaf(otherlv_6, elementTypeProvider.getFamilie_CommaKeyword_6_0ElementType());
			}
			(
				(
					{
						markLeaf();
					}
					otherlv_7=RULE_ID
					{
						doneLeaf(otherlv_7, elementTypeProvider.getFamilie_KinderKindCrossReference_6_1_0ElementType());
					}
				)
			)
		)*
		{
			markLeaf();
		}
		otherlv_8=')'
		{
			doneLeaf(otherlv_8, elementTypeProvider.getFamilie_RightParenthesisKeyword_7ElementType());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;