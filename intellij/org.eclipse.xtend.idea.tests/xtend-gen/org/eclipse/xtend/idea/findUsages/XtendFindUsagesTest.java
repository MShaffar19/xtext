/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.findUsages;

import com.google.common.base.Objects;
import com.intellij.codeInsight.highlighting.HighlightUsagesHandler;
import com.intellij.find.FindManager;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesManager;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.find.impl.FindManagerImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.CommonProcessors;
import java.util.Collection;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFindUsagesTest extends LightXtendTest {
  public void testFindUsagesWihtSourceElement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final PsiNamedElement element = this.getNamedElementAt(file, "MyClass");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiClass:MyClass");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(element, _builder_1.toString());
  }
  
  public void testFindUsagesWihtSourceElement_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyClass2 extends MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("mypackage/MyClass2.xtend", _builder_1.toString());
    final PsiNamedElement element = this.getNamedElementAt(file, "MyClass");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("primaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("MyClass (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/mypackage/MyClass2.xtend");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 42");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("secondaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("PsiClass:MyClass {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 37");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 102");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.testFindUsages(element, _builder_2.toString());
  }
  
  public void testFindUsagesWihtSourceElement_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 304");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiMethod:setX");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiParameter:x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 308");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testFindUsagesWihtSourceElement_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int y");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("y (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/mypackage/MyClass.xtend");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 128");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:y {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 251");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 364");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 417");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiMethod:getY");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiMethod:setY");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiParameter:y {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 421");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testFindUsagesWihtGeneratedElement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    final PsiNamedElement element = this.getNamedElementAt(generatedSource, "MyClass");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiClass:MyClass");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(element, _builder_1.toString());
  }
  
  public void testFindUsagesWihtGeneratedElement_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyClass2 extends MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("mypackage/MyClass2.xtend", _builder_1.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    final PsiNamedElement element = this.getNamedElementAt(generatedSource, "MyClass");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("primaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("PsiClass:MyClass {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 37");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 102");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("secondaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("MyClass (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/mypackage/MyClass2.xtend");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 42");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.testFindUsages(element, _builder_2.toString());
  }
  
  public void testFindUsagesWihtGeneratedElement_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 304");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testFindUsagesWihtGeneratedElement_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int y");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:y {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 251");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 364");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 417");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("y (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/mypackage/MyClass.xtend");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 128");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithSourceElement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithSourceElement_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("XtextPsiReferenceImpl {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : org.eclipse.xtext.psi.impl.PsiEObjectReference(XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(125,126)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithSourceElement_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfGetX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getX");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("XtextPsiReferenceImpl {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : org.eclipse.xtext.psi.impl.PsiEObjectReference(XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(128,132)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithSourceElement_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfGetX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getX");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("XtextPsiReferenceImpl {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : org.eclipse.xtext.psi.impl.PsiEObjectReference(XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(125,126)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("XtextPsiReferenceImpl {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : org.eclipse.xtext.psi.impl.PsiEObjectReference(XFeatureCall_FeatureJvmIdentifiableElementCrossReference_2_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(153,157)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithGeneratedElement_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(239,240)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(292,293)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithGeneratedElement_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(235,236)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(291,292)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(344,345)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithGeneratedElement_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfGetX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getX");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(299,300)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(352,353)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testHighlightUsagesWithGeneratedElement_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def usageOfGetX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getX");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("references {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(235,236)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(351,352)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiReferenceExpression:this.x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("element : PsiReferenceExpression:this.x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("rangesToHighlight {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("(404,405)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testHighlightUsages(_namedElementAt, _builder_1.toString());
  }
  
  protected PsiNamedElement getNamedElementAt(final PsiFile file, final String substring) {
    PsiNamedElement _xblockexpression = null;
    {
      String _text = file.getText();
      final int offset = _text.indexOf(substring);
      PsiElement _findElementAt = file.findElementAt(offset);
      _xblockexpression = PsiTreeUtil.<PsiNamedElement>getParentOfType(_findElementAt, PsiNamedElement.class, false);
    }
    return _xblockexpression;
  }
  
  protected void testHighlightUsages(final PsiElement element, final String expectation) {
    FindUsagesHandler _highlightUsagesHandler = this.getHighlightUsagesHandler(element);
    String _printHighlightUsages = this.printHighlightUsages(_highlightUsagesHandler, element);
    TestCase.assertEquals(expectation, _printHighlightUsages);
  }
  
  protected String printHighlightUsages(final FindUsagesHandler findUsagesHandler, final PsiElement element) {
    String _xblockexpression = null;
    {
      PsiFile _containingFile = element.getContainingFile();
      final LocalSearchScope scope = new LocalSearchScope(_containingFile);
      final Collection<PsiReference> references = findUsagesHandler.findReferencesToHighlight(element, scope);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("references {");
      _builder.newLine();
      {
        for(final PsiReference reference : references) {
          _builder.append("\t");
          _builder.append(reference, "\t");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("element : ");
          PsiElement _element = reference.getElement();
          _builder.append(_element, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("rangesToHighlight {");
          _builder.newLine();
          {
            List<TextRange> _rangesToHighlight = HighlightUsagesHandler.getRangesToHighlight(reference);
            for(final TextRange rangeToHighlight : _rangesToHighlight) {
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append(rangeToHighlight, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected void testFindUsages(final PsiElement element, final String expectation) {
    FindUsagesHandler _findUsagesHandler = this.getFindUsagesHandler(element);
    String _printUsages = this.printUsages(_findUsagesHandler);
    TestCase.assertEquals(expectation, _printUsages);
  }
  
  protected String printUsages(final FindUsagesHandler findUsagesHandler) {
    String _xblockexpression = null;
    {
      final PsiElement[] primaryElements = findUsagesHandler.getPrimaryElements();
      final PsiElement[] secondaryElements = findUsagesHandler.getSecondaryElements();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("primaryElements {");
      _builder.newLine();
      _builder.append("\t");
      String _printUsages = this.printUsages(findUsagesHandler, primaryElements);
      _builder.append(_printUsages, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.append("secondaryElements {");
      _builder.newLine();
      _builder.append("\t");
      String _printUsages_1 = this.printUsages(findUsagesHandler, secondaryElements);
      _builder.append(_printUsages_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String printUsages(final FindUsagesHandler findUsagesHandler, final PsiElement... elements) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final PsiElement element : elements) {
        _builder.append(element, "");
        final Collection<UsageInfo> usages = this.findUsages(findUsagesHandler, element);
        {
          boolean _isEmpty = usages.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            {
              for(final UsageInfo usage : usages) {
                _builder.append("\t");
                _builder.append(usage, "\t");
                _builder.append(" {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("virtualFile : ");
                VirtualFile _virtualFile = usage.getVirtualFile();
                _builder.append(_virtualFile, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("navigationOffset : ");
                int _navigationOffset = usage.getNavigationOffset();
                _builder.append(_navigationOffset, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected Collection<UsageInfo> findUsages(final FindUsagesHandler findUsagesHandler, final PsiElement... elements) {
    Collection<UsageInfo> _xblockexpression = null;
    {
      final CommonProcessors.CollectProcessor<UsageInfo> processor = new CommonProcessors.CollectProcessor<UsageInfo>();
      final FindUsagesOptions options = findUsagesHandler.getFindUsagesOptions(null);
      for (final PsiElement element : elements) {
        findUsagesHandler.processElementUsages(element, processor, options);
      }
      _xblockexpression = processor.getResults();
    }
    return _xblockexpression;
  }
  
  protected FindUsagesHandler getHighlightUsagesHandler(final PsiElement element) {
    FindManagerImpl _findManager = this.getFindManager();
    FindUsagesManager _findUsagesManager = _findManager.getFindUsagesManager();
    return _findUsagesManager.getFindUsagesHandler(element, true);
  }
  
  protected FindUsagesHandler getFindUsagesHandler(final PsiElement element) {
    FindManagerImpl _findManager = this.getFindManager();
    FindUsagesManager _findUsagesManager = _findManager.getFindUsagesManager();
    return _findUsagesManager.getFindUsagesHandler(element, false);
  }
  
  protected FindManagerImpl getFindManager() {
    Project _project = this.myFixture.getProject();
    FindManager _instance = FindManager.getInstance(_project);
    return ((FindManagerImpl) _instance);
  }
}