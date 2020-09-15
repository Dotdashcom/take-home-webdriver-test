import framework.Pages.CheckBoxPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class CheckBoxTest extends WebDriverWrapper{

    @Test
    public void checkCheckBox(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickCheckboxes();
        CheckBoxPage checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);
        checkBoxPage.checkCheckBoxOne();
    }

    @Test
    public void uncheckCheckBox(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickCheckboxes();
        CheckBoxPage checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);
        checkBoxPage.uncheckCheckBoxTwo();
    }
}
