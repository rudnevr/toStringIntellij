PsiParameter_ [] parameters = [new PsiParameter_('int', 'a')]
PsiParameter_ method = new PsiParameter_('', 'methodName')

params = parameters.collect {
    if (it.type == 'int[]')
        return '\"' + it.type + '\"' + it.name + '= new ' + it.type + '{ \" + java.util.Arrays.toString(' + it.name + ').replaceAll(\"^.&.$\",\"\") + \"};\"';
    if (it.type == 'int')
        return '\"' + it.type + ' ' + it.name + '= \"+' + it.name;
    if (it.type == 'String')
        return '\"' + it.type + ' ' + it.name + '= \\\\\"\"+' + it.name + '+\"\\\\\"\"';
}.join('+\"; \"+');

res = '\"' + method.name + '(' + parameters.collect {
    return it.name;
}.join(' , ');

System.out.println( params + ' + ' + res + ');\"');
