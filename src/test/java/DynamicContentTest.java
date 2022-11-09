import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContentPage;
import pages.HomePage;

public class DynamicContentTest extends BaseTest {

    @Test
    public void DynamicContentActionTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        DynamicContentPage dynamicContentPage = new DynamicContentPage();

        boolean header = dynamicContentPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        boolean result = dynamicContentPage.dynamicRefresh();
        Assert.assertTrue(result, "validation is not successful");

    }

}
