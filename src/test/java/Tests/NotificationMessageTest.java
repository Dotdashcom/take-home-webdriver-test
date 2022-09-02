package Tests;

import Pages.NotificationPage;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationMessageTest {
    String baseURL="http://localhost:7080";
    @Test
    public void notificationMessage(){
        NotificationPage notificationPage=new NotificationPage();
        Driver.getDriver().get(baseURL+"/notification_message_rendered");

        assertTrue(notificationPage.notificationMessage.isDisplayed());

    }
}
