import org.benjamin.pages.JsAlert;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JsAlertTest extends JsAlert {
    @BeforeAll
    public void init() {
        super.init();
    }

    @AfterAll
    public void destroy() {
        super.destroy();
    }

    @Test
    public void alert_alert_displayCorrectMessage(){
        clickAlert();
        Assertions.assertEquals("You successfuly clicked an alert", getAlertMessage());
    }

    @Test
    public void alert_confirm_displayCorrectMessage(){
        clickConfirm();
        Assertions.assertEquals("You clicked: Ok", getAlertMessage());
    }

    @Test
    public void alert_prompt_displayCorrectMessage(){
        String input = "test";
        inputPrompt(input);
        Assertions.assertEquals("You entered: " + input, getAlertMessage());
    }
}
