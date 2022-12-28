package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.NotificationMessagePage;

public class NotificationMsgTest extends GenericPage {
	NotificationMessagePage notificMsgPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/notification_message_rendered");
		notificMsgPage = new NotificationMessagePage();
	}

	@Test
	public void tcNotificationMsg() throws InterruptedException {
		Assert.assertTrue(notificMsgPage.getNotificationMsgBool());
	}
}