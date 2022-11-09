import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTest extends BaseTest {

    @Test
    public void DropdownActionTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        DropdownPage dropdownPage = new DropdownPage();

        boolean header = dropdownPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        String result = dropdownPage.VerifyDropdown();
        Assert.assertFalse(result.isEmpty(), "validation is not successful");

    }

}
