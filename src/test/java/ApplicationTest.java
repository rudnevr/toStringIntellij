import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    void name() {
        new Application().methodName(3, 5);
    }

    @Test
    void complexTypes() {
        new Application().acceptAndReturn(ClazzFactory.buildClazzWithAllProps());
    }
}
