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
class CallGenerator {

    String generateCallFromParams(String methodName, PsiParameter_[] parameters, String returnType, String className) {

        String params = parameters.collect {
            if (it.type == 'int[]')
                return '\"' + it.type + '\"' + it.name + '= new ' + it.type + '{ \" + java.util.Arrays.toString(' + it.name + ').replaceAll(\"^.&.$\",\"\") + \"};\"';
            if (it.type == 'int')
                return it.type + ' ' + it.name + ' = \" + ' + it.name + ' + \";\" + \"';
            if (it.type == 'String')
                return '\"' + it.type + ' ' + it.name + '= \\\\\"\"+' + it.name + '+\"\\\\\"\"';
            else
                return it.type + ' ' + it.name + ' = \" + ' + it.name + '.toString()' + ' + \";\" + \"';
        }.join('');

        String methodCall = methodName + '(' + parameters.collect {
            return it.name;
        }.join(', ');

        return '\"' + params + returnType + ' actual=new ' + className + '().' + methodCall + ');\"';
    }
};
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

", methodParameters())

