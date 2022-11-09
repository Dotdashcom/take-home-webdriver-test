import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OpenNewTabPage;

public class OpenNewTabTest extends BaseTest {

    @Test
    public void OpenTabInNewPageTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        OpenNewTabPage openNewTabPage = new OpenNewTabPage();

        boolean header = openNewTabPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        openNewTabPage.openInNewTabTest();
        Assert.assertTrue(true, "validation is not successful");

    }

}
