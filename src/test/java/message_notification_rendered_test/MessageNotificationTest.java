package message_notification_rendered_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.message_notification_rendered_page.MessageNotificationPage;

import static org.testng.Assert.assertTrue;

public class MessageNotificationTest extends Base {
    @Test
    public void messageNotificationTest() {
        MessageNotificationPage messageNotificationPage = new MessageNotificationPage();
        messageNotificationPage.setClickLink();
        String expectedMessageOne = "Action successful\n" +
                "×";
        String expectedMessageTwo = "Action unsuccesful, please try again\n" +
                "×";
        String actualMessage = MessageNotificationPage.notificationMessage.getText();
        System.out.println(actualMessage);
        assertTrue(MessageNotificationPage.notificationMessage.getText().equals(expectedMessageOne) || MessageNotificationPage.notificationMessage.getText().equals(expectedMessageTwo));
    }
}
