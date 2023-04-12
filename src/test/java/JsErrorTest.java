import org.benjamin.pages.JsAlert;
import org.benjamin.pages.JsError;
import org.junit.jupiter.api.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.Logs;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JsErrorTest extends JsError {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void jsError_onload_containsError(){
        LogEntries logs = checkLogs();
        boolean isUndefinedError =
                logs.getAll().stream().filter(l->l.getMessage().contains("Cannot read property 'xyz' of undefined.")).count() > 0;
        // the error is "Cannot read properties if undefined (reading 'xyz')" wording not the same
        Assertions.assertTrue(isUndefinedError);
    }
}
