package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.NotificationMessage;

public class NotificationMessageTest extends TestBase {

    @Test
    public void notificationMessageTest(){
        NotificationMessage notificationMessage =new NotificationMessage(driver);
        notificationMessage.clickNotification();
    }

}
