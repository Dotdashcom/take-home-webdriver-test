import framework.Pages.HomePage;
import framework.Pages.WindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class WindowsTest extends WebDriverWrapper {

    @Test
    public void verifyNewWindow(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickMultipleWindow();
        WindowsPage windowsPage = PageFactory.initElements(driver, WindowsPage.class);
        windowsPage.openSecondWindow();
    }
}
