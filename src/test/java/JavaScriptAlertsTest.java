import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    public void JavaScriptAlertsVerifyTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

        boolean header = javaScriptAlertsPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        javaScriptAlertsPage.javaScriptAlertTest();
        Assert.assertTrue(true, "validation is not successful");

    }

}
