import framework.Pages.HomePage;
import framework.Pages.JavaScriptsAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class JavaScriptsAlertsTest extends WebDriverWrapper {

    @Test
    public void verifyJSAlerts(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickJavaScriptAlert();
        JavaScriptsAlertsPage javaScriptsAlertsPage = PageFactory.initElements(driver,JavaScriptsAlertsPage.class);
        javaScriptsAlertsPage.dismissJSAlert();
        javaScriptsAlertsPage.confirmJSConfirm();
        javaScriptsAlertsPage.inputTextToPrompt("Hello, World!");

    }
}
