import framework.Pages.DynamicContentPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class DynamicContentTest extends WebDriverWrapper{


    @Test
    public void testDynamicContent(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickDynamicContent();
        DynamicContentPage dynamicContentPage = PageFactory.initElements(driver, DynamicContentPage.class);
        dynamicContentPage.verifyTextChange();
        dynamicContentPage.verifyImageChange();
    }
}
