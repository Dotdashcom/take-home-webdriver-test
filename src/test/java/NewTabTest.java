import org.benjamin.pages.JsError;
import org.benjamin.pages.NewTab;
import org.junit.jupiter.api.*;
import org.openqa.selenium.logging.LogEntries;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NewTabTest extends NewTab {
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
        openNewTab();
        Assertions.assertTrue(checkNewTab());
    }
}
