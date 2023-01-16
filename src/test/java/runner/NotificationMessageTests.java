package runner;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import utilities.DriverUtil;
import utilities.PropertiesReadingUtil;


public class NotificationMessageTests extends TestBase {
  NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

  @Test
  public void testNotifications() {
    DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("baseUrl") + "notification_message_rendered");

    String actText = notificationMessagePage.test();
    System.out.println(actText);
    Assert.assertFalse(actText.contains("Action Successful\n" + "�") || actText.contains("Action unsuccessful, please try again\n" + "�") ||
      actText.contains("Action Unsuccessful\n" + "�"));

  }
}
