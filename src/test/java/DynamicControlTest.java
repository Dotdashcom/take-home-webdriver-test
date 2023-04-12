import org.benjamin.pages.DynamicControl;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DynamicControlTest extends DynamicControl {
    public WebDriver driver;
    @BeforeAll
    public void init(){
        super.init();
    }

    @AfterAll
    public void destroy(){
        super.destroy();
    }

    @Test
    @Order(1)
    public void checkbox_remove_gone(){
        Assertions.assertTrue(clickRemoveOrAddButton());
    }

    @Test
    @Order(2)
    public void checkbox_add_appear(){
        Assertions.assertFalse(clickRemoveOrAddButton());
    }

    @Test
    @Order(3)
    public void textbox_enableButton_enabled(){
        String disabled = clickDisableEnableButton();
        Assertions.assertNull(disabled);
    }

    @Test
    @Order(4)
    public void textbox_disableButton_disabled(){
        String disabled = clickDisableEnableButton();
        Assertions.assertEquals("true", disabled);
    }
}
