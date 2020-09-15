import framework.Pages.ContextMenuPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class ContextMenuTest extends WebDriverWrapper {

    @Test
    public void verifyAlertText(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickContextMenu();
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.verifyJavaScriptAlert();
    }
}
