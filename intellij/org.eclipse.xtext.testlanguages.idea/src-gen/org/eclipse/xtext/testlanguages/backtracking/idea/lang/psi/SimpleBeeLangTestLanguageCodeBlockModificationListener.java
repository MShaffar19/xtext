package org.eclipse.xtext.testlanguages.backtracking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

public class SimpleBeeLangTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SimpleBeeLangTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SimpleBeeLangTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}