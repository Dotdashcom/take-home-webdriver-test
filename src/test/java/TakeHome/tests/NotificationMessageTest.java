package TakeHome.tests;

import TakeHome.pages.NotificationMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationMessageTest extends TestBase {
    List<String> notificationMessages = new ArrayList<>(Arrays.asList("Action successful", "Action Unsuccessful", "Action unsuccesful, please try again"));

    @Test(groups = "Message")
    public void test1() {
        NotificationMessagePage page = new NotificationMessagePage();

        for (int i = 0; i <=10 ; i++) {
            Assert.assertTrue(notificationMessages.contains(page.getNotificationText()),
                    "notification displayed is not as expected, found " + page.getNotificationText() + " instead" );        }
    }

}


