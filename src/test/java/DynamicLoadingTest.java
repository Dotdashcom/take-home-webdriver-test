import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.HomePage;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void DynamicLoadingActionTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

        boolean header = dynamicLoadingPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        String result = dynamicLoadingPage.dynamicLoading();
        Assert.assertEquals(result, "Hello World!", "validation is not successful");


    }

}
