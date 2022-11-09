import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.HomePage;

public class CheckBoxTest extends BaseTest {

    @Test
    public void CheckBoxesTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        CheckBoxPage checkBoxPage = new CheckBoxPage();
        boolean header = checkBoxPage.navigatetoCheckBoxpage().checkboxHeader();
        Assert.assertTrue(header, "checkboxes page is not navigated");
        boolean check = checkBoxPage.checkBoxVerification();
        Assert.assertTrue(check, "checkboxes validation is not successful");

    }

}
