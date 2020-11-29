groovyScript("
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

def file = PsiDocumentManager.getInstance(_editor.project).getPsiFile(_editor.document);
PsiMethod method = PsiTreeUtil.findElementOfClassAtOffset(file, _editor.caretModel.offset, PsiMethod.class, false);
PsiParameter[] parameters = method == null ? PsiParameter.EMPTY_ARRAY : method.parameterList.parameters;
PsiParameter_[] params = parameters.collect {
        return new PsiParameter_(it.type.presentableText, it.name);
};
out = params.collect() {
    return it.toString();
}.join(';');

return out;
", methodParameters() )
