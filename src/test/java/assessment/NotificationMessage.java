package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import util.Driver;

import java.util.Arrays;

public class NotificationMessage extends Driver {

    NotificationMessagePage page = new NotificationMessagePage(Driver.getDriver());

    @Test
    public void notification_message_test() {
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

        // typo in the "Action unsuccessful, please try again" on the site -> unsuccessful was spelled unsuccesful with one 's'
        // did not come across the "Action Unsuccessful" message included in the expected list of messages provided by the instructions
        String[] possibleMessages = {"Action unsuccesful, please try again" , "Action successful" , "Action Unsuccessful"};

        for (int i = 0; i < 10; i++) {
            page.clickHereLink.click();
            String actualText = page.notificationMsg.getText();
            Assert.assertTrue(Arrays.asList(possibleMessages).contains(actualText.substring(0 , actualText.lastIndexOf('\n'))));
        }
    }
}
