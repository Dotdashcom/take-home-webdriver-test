import framework.Pages.DropDownPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class DropDownTest extends WebDriverWrapper {

    @Test
    public void dropDownTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickDropDown();
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.selectFromDropdown("Option 1");
        dropDownPage.selectFromDropdown("Option 2");
    }

}
