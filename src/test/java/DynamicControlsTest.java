import framework.Pages.DynamicControlsPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class DynamicControlsTest extends WebDriverWrapper {


    @Test
    public void testDynamicControls(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickDynamicControls();
        DynamicControlsPage dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
        dynamicControlsPage.verifyCheckBoxRemove();
        dynamicControlsPage.verifyCheckBoxAdd();
        dynamicControlsPage.verifyInputEnabled();
        dynamicControlsPage.verifyInputDisabled();
    }
}
