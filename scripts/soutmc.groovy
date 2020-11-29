groovyScript("
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

def file = PsiDocumentManager.getInstance(_editor.project).getPsiFile(_editor.document);
PsiMethod method = PsiTreeUtil.findElementOfClassAtOffset(file, _editor.caretModel.offset, PsiMethod.class, false);
PsiParameter[] parameters = method == null ? PsiParameter.EMPTY_ARRAY : method.parameterList.parameters;

params = parameters.collect {
    if (it.type instanceof PsiArrayType && it.type.componentType instanceof PsiPrimitiveType)
        return '\"' + it.type.presentableText + '\"' + it.name + '= new ' + it.type.presentableText + '{ \" + java.util.Arrays.toString(' + it.name + ').replaceAll(\"^.&.$\",\"\") + \"};\"';
    if (it.type instanceof PsiPrimitiveType)
        return '\"' + it.type.presentableText + ' ' + it.name + '= \"+' + it.name;
    if (it.type.presentableText == 'String')
        return '\"' + it.type.presentableText + ' ' + it.name + '= \\\\\"\"+' + it.name + '+\"\\\\\"\"';
}.join('+\"; \"+');

res = '\"' + method.name + '(' + parameters.collect {
    return it.name;
}.join(' , ');

return params + ' + ' + res + ');\"';
", methodParameters())
