package Tests;

import Pages.BasePage;
import Pages.NotificationMessagePage;
import Utils.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationTest extends BasePage {
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/notification_message_rendered ");
    }

    @Test
    public void TC1FirstClickNotification() {
        int count = 0;
        while (count <= 3) {
            notificationMessagePage.ClickLink();
            String message = notificationMessagePage.NotificationMessage();
            System.out.println("The success message is " + message);
            count++;
        }
    }
}
