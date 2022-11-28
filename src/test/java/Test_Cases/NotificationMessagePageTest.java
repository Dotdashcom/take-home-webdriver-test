package Test_Cases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.NotificationMessagePage;
import TestBase.BaseTest;

public class NotificationMessagePageTest extends BaseTest {
	NotificationMessagePage notificationMessage;

	public NotificationMessagePageTest() {
		super();
	}

	@BeforeClass
	void setup() {
		notificationMessage = new NotificationMessagePage();
	}

	@Test
	public void verifyNotificationMessage() {
		// Log.info("Trying to logging into the application.");
		// logging into application
		notificationMessage.getUrl();
		String message = "";
		// click on the link to display the notification message
		for (int i = 0; i < 5; i++) {
			notificationMessage.clickHere();
			// getting the message from the element
			message = notificationMessage.getNotificationMessageText().trim();
			System.out.println(message);
			Assert.assertTrue(message.contains("Action successful") || message.contains("Action unsuccesful"));
		}
	}

}
