package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.NotificationMessagePage;

public class NotificationMessageTest {
	
	@Test
	public void verifyNotificatMessageCheck() {
		Page.initConfiguration("notification_message_rendered");
		NotificationMessagePage nmp = new NotificationMessagePage();
		nmp.verifyNotificationMessage();
		Page.quitBrowser();
	}

}
