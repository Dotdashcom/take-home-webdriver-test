package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.NotificationMessagePage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class NotificationMessageTest extends InternetWebBaseTest {
	@Test
	public void testNotificationMessageTest() throws IOException {
  		driver.get(loadProperties().getProperty("BASE_URL")+"notification_message_rendered");
  		NotificationMessagePage message=new NotificationMessagePage(driver);
  		message.searchlink();
  		Assert.assertTrue("not getting Notification Message",message.msg().contains("Action successful")|| message.msg().contains("Action unsuccesful, please try again")); // notificationText.contains(\"Action unsuccesful, please try again\")");

	}

}
