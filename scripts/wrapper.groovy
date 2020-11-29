groovyScript("
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
class PsiParameter_ {
    java.lang.String type;
    java.lang.String name;
    java.lang.Object value;

    PsiParameter_(String type, String name) {
        this.type = type;
        this.name = name;
    };

    PsiParameter_(String type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
    };

    @Override
    public String toString() {
        return type + ':' + name;
    };
};

def file = PsiDocumentManager.getInstance(_editor.project).getPsiFile(_editor.document);
PsiMethod method = PsiTreeUtil.findElementOfClassAtOffset(file, _editor.caretModel.offset, PsiMethod.class, false);
PsiParameter[] parameters = method == null ? PsiParameter.EMPTY_ARRAY : method.parameterList.parameters;
String returnType = method.returnType.presentableText;
String className= method.containingClass.name;
String methodName = method.name;
PsiParameter_[] params = parameters.collect {
        return new PsiParameter_(it.type.presentableText, it.name);
};
out = params.collect() {
    return it.toString();
}.join(';');

return [out, returnType, methodName, className].join(' | ');
", methodParameters() )
