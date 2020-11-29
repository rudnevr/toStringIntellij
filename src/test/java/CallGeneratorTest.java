import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CallGeneratorTest {
    @Test
    void whenParamsInt_shouldGenerateCall() {
        CallGenerator callGenerator = new CallGenerator();
        String actual = callGenerator.generateCallFromParams("methodName", new PsiParameter_[]{new PsiParameter_("int", "a")}, "String", "Application");
        assertThat(actual).isEqualTo("\"int a = \" + a + \";\" + \"String actual=new Application().methodName(a);\"");
    }

    @Test
    void whenParamsTwoInts_shouldGenerateCall() {
        CallGenerator callGenerator = new CallGenerator();
        String actual = callGenerator.generateCallFromParams("methodName", new PsiParameter_[]{new PsiParameter_("int", "a"), new PsiParameter_("int", "b") }, "String", "Application");
//        assertThat(actual).isEqualTo("methodName(a, b);");
//        assertThat(actual).isEqualTo("\"int a = \" + a + \";\" + \"int b = \" + b + \";\" + \"\nmethodName(a, b);\"");
        assertThat(actual).isEqualTo("\"int a = \" + a + \";\" + \"int b = \" + b + \";\" + \"String actual=new Application().methodName(a, b);\"");
    }

    @Test
    void whenParamClazz_shouldGenerateCall() {
        CallGenerator callGenerator = new CallGenerator();
        String actual = callGenerator.generateCallFromParams("methodName", new PsiParameter_[]{new PsiParameter_("Clazz", "clazz") }, "Clazz", "Application");
//        assertThat(actual).isEqualTo("methodName(a, b);");
//        assertThat(actual).isEqualTo("\"int a = \" + a + \";\" + \"int b = \" + b + \";\" + \"\nmethodName(a, b);\"");
        assertThat(actual).isEqualTo("\"Clazz clazz = \" + clazz.toString() + \";\" + \"Clazz actual=new Application().methodName(clazz);\"");

    }

}
