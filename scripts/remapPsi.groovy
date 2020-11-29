def file = PsiDocumentManager.getInstance(_editor.project).getPsiFile(_editor.document);
PsiMethod method = PsiTreeUtil.findElementOfClassAtOffset(file, _editor.caretModel.offset, PsiMethod.class, false);
PsiParameter[] psi_parameters = method == null ? PsiParameter.EMPTY_ARRAY : method.parameterList.parameters;

String returnType = method.returnType.presentableText;
String className= method.containingClass.name;
String methodName = method.name;

PsiParameter_[] parameters = psi_parameters.collect {
    return new PsiParameter_(it.type.presentableText, it.name);
};

return new CallGenerator().generateCallFromParams(methodName, parameters, returnType, className);

