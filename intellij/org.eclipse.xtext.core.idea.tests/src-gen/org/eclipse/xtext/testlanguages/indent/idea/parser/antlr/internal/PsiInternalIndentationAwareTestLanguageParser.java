package org.eclipse.xtext.testlanguages.indent.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.testlanguages.indent.services.IndentationAwareTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalIndentationAwareTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_BEGIN", "RULE_END", "RULE_OTHER"
    };
    public static final int RULE_OTHER=7;
    public static final int RULE_END=6;
    public static final int RULE_BEGIN=5;
    public static final int RULE_NL=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public PsiInternalIndentationAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalIndentationAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalIndentationAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g"; }



    	protected IndentationAwareTestLanguageGrammarAccess grammarAccess;

    	protected IndentationAwareTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalIndentationAwareTestLanguageParser(PsiBuilder builder, TokenStream input, IndentationAwareTestLanguageElementTypeProvider elementTypeProvider, IndentationAwareTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "NodeList";
    	}




    // $ANTLR start "entryRuleNodeList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:50:1: entryRuleNodeList : ruleNodeList EOF ;
    public final void entryRuleNodeList() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:50:18: ( ruleNodeList EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:51:2: ruleNodeList EOF
            {
             markComposite(elementTypeProvider.getNodeListElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeList_in_entryRuleNodeList54);
            ruleNodeList();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeList60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNodeList"


    // $ANTLR start "ruleNodeList"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:59:1: ruleNodeList : ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* ) ;
    public final void ruleNodeList() throws RecognitionException {
        Token this_NL_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:59:13: ( ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:60:2: ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:60:2: ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:61:3: ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:61:3: ( (lv_children_0_0= ruleNode ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:62:4: (lv_children_0_0= ruleNode )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:62:4: (lv_children_0_0= ruleNode )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:63:5: lv_children_0_0= ruleNode
            {

            					markComposite(elementTypeProvider.getNodeList_ChildrenNodeParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_ruleNodeList96);
            ruleNode();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:72:3: (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:73:4: this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) )
            	    {

            	    				markLeaf();
            	    			
            	    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleNodeList127); 

            	    				doneLeaf(this_NL_1, elementTypeProvider.getNodeList_NLTerminalRuleCall_1_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:80:4: ( (lv_children_2_0= ruleNode ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:81:5: (lv_children_2_0= ruleNode )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:81:5: (lv_children_2_0= ruleNode )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:82:6: lv_children_2_0= ruleNode
            	    {

            	    						markComposite(elementTypeProvider.getNodeList_ChildrenNodeParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleNode_in_ruleNodeList159);
            	    ruleNode();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleNodeList"


    // $ANTLR start "entryRuleNode"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:96:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:96:14: ( ruleNode EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:97:2: ruleNode EOF
            {
             markComposite(elementTypeProvider.getNodeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_entryRuleNode198);
            ruleNode();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNode204); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:105:1: ruleNode : ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? ) ;
    public final void ruleNode() throws RecognitionException {
        Token this_NL_1=null;
        Token this_BEGIN_2=null;
        Token this_END_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:105:9: ( ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:106:2: ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:106:2: ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:107:3: ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:107:3: ( (lv_name_0_0= ruleString ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:108:4: (lv_name_0_0= ruleString )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:108:4: (lv_name_0_0= ruleString )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:109:5: lv_name_0_0= ruleString
            {

            					markComposite(elementTypeProvider.getNode_NameStringParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleString_in_ruleNode240);
            ruleString();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:118:3: (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_NL) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_BEGIN) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:119:4: this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END
                    {

                    				markLeaf();
                    			
                    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleNode271); 

                    				doneLeaf(this_NL_1, elementTypeProvider.getNode_NLTerminalRuleCall_1_0ElementType());
                    			

                    				markLeaf();
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FollowSets000.FOLLOW_RULE_BEGIN_in_ruleNode288); 

                    				doneLeaf(this_BEGIN_2, elementTypeProvider.getNode_BEGINTerminalRuleCall_1_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:133:4: ( (lv_children_3_0= ruleNodeList ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:134:5: (lv_children_3_0= ruleNodeList )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:134:5: (lv_children_3_0= ruleNodeList )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:135:6: lv_children_3_0= ruleNodeList
                    {

                    						markComposite(elementTypeProvider.getNode_ChildrenNodeListParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNodeList_in_ruleNode320);
                    ruleNodeList();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf();
                    			
                    this_END_4=(Token)match(input,RULE_END,FollowSets000.FOLLOW_RULE_END_in_ruleNode350); 

                    				doneLeaf(this_END_4, elementTypeProvider.getNode_ENDTerminalRuleCall_1_3ElementType());
                    			

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleString"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:156:1: entryRuleString : ruleString EOF ;
    public final void entryRuleString() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:156:16: ( ruleString EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:157:2: ruleString EOF
            {
             markComposite(elementTypeProvider.getStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleString_in_entryRuleString376);
            ruleString();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleString382); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleString"


    // $ANTLR start "ruleString"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:165:1: ruleString : (this_OTHER_0= RULE_OTHER )+ ;
    public final void ruleString() throws RecognitionException {
        Token this_OTHER_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:165:11: ( (this_OTHER_0= RULE_OTHER )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:166:2: (this_OTHER_0= RULE_OTHER )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:166:2: (this_OTHER_0= RULE_OTHER )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_OTHER) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/indent/idea/parser/antlr/internal/PsiInternalIndentationAwareTestLanguage.g:167:3: this_OTHER_0= RULE_OTHER
            	    {

            	    			markLeaf();
            	    		
            	    this_OTHER_0=(Token)match(input,RULE_OTHER,FollowSets000.FOLLOW_RULE_OTHER_in_ruleString405); 

            	    			doneLeaf(this_OTHER_0, elementTypeProvider.getString_OTHERTerminalRuleCallElementType());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleNodeList_in_entryRuleNodeList54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeList60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNode_in_ruleNodeList96 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleNodeList127 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleNode_in_ruleNodeList159 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNode_in_entryRuleNode198 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNode204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleString_in_ruleNode240 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleNode271 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_BEGIN_in_ruleNode288 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleNodeList_in_ruleNode320 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_END_in_ruleNode350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleString_in_entryRuleString376 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleString382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_OTHER_in_ruleString405 = new BitSet(new long[]{0x0000000000000082L});
    }


}