import framework.Pages.HomePage;
import framework.Pages.NotificationMessagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class NotificationMessageTest extends WebDriverWrapper {


    @Test
    public void testNotificationMessage(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickNotification();
        NotificationMessagePage notificationMessagePage = PageFactory.initElements(driver, NotificationMessagePage.class);
        notificationMessagePage.generateNotifcationMessage();
        notificationMessagePage.generateNotifcationMessage();
        notificationMessagePage.generateNotifcationMessage();
        notificationMessagePage.generateNotifcationMessage();

    }
}
