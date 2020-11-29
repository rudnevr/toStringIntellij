import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CallGeneratorTest {
    @Test
    void whenParamsInt_shouldGenerateCall() {
        CallGenerator callGenerator = new CallGenerator();
        String actual = callGenerator.generateCallFromParams("methodName", new PsiParameter_[]{new PsiParameter_("int", "a")});
        assertThat(actual).isEqualTo("methodName(a);");
    }

    @Test
    void whenParamsTwoInts_shouldGenerateCall() {
        CallGenerator callGenerator = new CallGenerator();
        String actual = callGenerator.generateCallFromParams("methodName", new PsiParameter_[]{new PsiParameter_("int", "a"), new PsiParameter_("int", "b")});
        assertThat(actual).isEqualTo("methodName(a, b);");
    }
}
