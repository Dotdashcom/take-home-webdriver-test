import org.benjamin.pages.NewTab;
import org.benjamin.pages.NotificationMessage;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NotificationMessageTest extends NotificationMessage {
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
        // not exact wording so wouldn't pass
        Assertions.assertTrue(checkMessage());
    }
}
