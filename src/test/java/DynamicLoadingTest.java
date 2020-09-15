import framework.Pages.DynamicLoadingPage;
import framework.Pages.DynamicLoadingTypesPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class DynamicLoadingTest extends WebDriverWrapper{

    @Test
    public void verifyLoadingElement(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickDynamicLoading();
        DynamicLoadingTypesPage dynamicLoadingTypesPage = PageFactory.initElements(driver, DynamicLoadingTypesPage.class);
        dynamicLoadingTypesPage.clickExampleTwo();
        DynamicLoadingPage dynamicLoadingPage = PageFactory.initElements(driver, DynamicLoadingPage.class);
        dynamicLoadingPage.verifyLoadedText();
    }
}
