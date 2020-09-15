import framework.Pages.FramePage;
import framework.Pages.HomePage;
import framework.Pages.IframePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class IframeTest extends WebDriverWrapper{

    @Test
    public void validateiFrameInput(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickFrame();
        FramePage framePage = PageFactory.initElements(driver, FramePage.class);
        framePage.clickIframe();
        IframePage iframePage = PageFactory.initElements(driver,IframePage.class);
        iframePage.writeInIframe("Hello World!");
    }
}
