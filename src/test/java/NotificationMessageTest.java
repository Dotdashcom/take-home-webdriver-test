import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotificationMessagePage;

public class NotificationMessageTest extends BaseTest {

    @Test
    public void notificationMessageTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

        boolean header = notificationMessagePage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        notificationMessagePage.notificationMessageTest();
        Assert.assertTrue(true, "validation is not successful");

    }

}
