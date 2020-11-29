groovyScript("
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

def file = PsiDocumentManager.getInstance(_editor.project).getPsiFile(_editor.document);
PsiMethod method = PsiTreeUtil.findElementOfClassAtOffset(file, _editor.caretModel.offset, PsiMethod.class, false);
PsiParameter[] parameters = method == null ? PsiParameter.EMPTY_ARRAY : method.parameterList.parameters;

res = '\"if(\" + ' + parameters.collect {
    if (it.type instanceof PsiArrayType && it.type.componentType instanceof PsiPrimitiveType)
        return '\"Arrays.equals(' + it.name + ', new ' + it.type.presentableText + '{ \" + java.util.Arrays.toString(' + it.name + ').replaceAll(\"^.&.$\",\"\") + \"})\"';
    else if (it.type instanceof PsiPrimitiveType)
        return '\"' + it.name + '==\" + ' + it.name
    else if (it.type.presentableText == 'String')
        return '\"' + it.name + '.equals(\\\\\"\"+' + it.name + '+\"\\\\\")\"';
    else
        return '\"' + it.name + '.equals(\" +' + it.name + '+ \")\"';
}.join('+\" && \" +');
return res + '+\")\"';
", methodParameters())
