import framework.Pages.HomePage;
import framework.Pages.HoverPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class HoverTest extends WebDriverWrapper{

    @Test
    public void verifyHoverOverTextAndLink(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickHover();
        HoverPage hoverPage = new HoverPage(driver);
        hoverPage.hoverOverImage();
    }
}
