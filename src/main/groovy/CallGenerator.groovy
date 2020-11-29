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
