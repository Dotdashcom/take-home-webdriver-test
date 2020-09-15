import framework.Pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class JavaScriptErrorTest extends WebDriverWrapper {

    @Test
    public void verifyJavaScriptError(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.captureJavaScriptErrorLog("Cannot read property 'xyz' of undefined");
        homePage.clickJavaScriptError();
    }
}
