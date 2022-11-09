import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import pages.HomePage;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void DynamicControlsActionTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

        boolean header = dynamicControlsPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        String result = dynamicControlsPage.dynamicRefreshWithRemoveCheckbox();
        Assert.assertEquals(result, "It's gone!", "validation is not successful");

        String resultBack = dynamicControlsPage.dynamicRefreshWithCheckboxBack();
        Assert.assertEquals(resultBack, "It's back!", "validation is not successful");

        String enabled = dynamicControlsPage.dynamicRefreshTestWithEnableButton();
        Assert.assertEquals(enabled, "It's enabled!", "validation is not successful");

        String disabled = dynamicControlsPage.dynamicRefreshTestWithDisableButton();
        Assert.assertEquals(disabled, "It's disabled!", "validation is not successful");


    }

}
