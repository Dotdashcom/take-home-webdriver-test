import framework.Pages.FloatingMenuPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class FloatingMenuTest extends WebDriverWrapper{

    @Test
    public void verifyFloatingMenu(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickFloatingMenu();
        FloatingMenuPage floatingMenuPage = PageFactory.initElements(driver, FloatingMenuPage.class);
        floatingMenuPage.scrollAndCheckMenu();
    }
}
