package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;

public class Test18_NotificationMessage extends NotificationMessagePage{
	
	Logger logger = LogManager.getLogger(Test18_NotificationMessage.class);

	String URL = prw.getProperties("baseURL");

	@BeforeMethod
	void openBrowser() {
		driver.get(URL + "/notification_message_rendered");
		logger.info("The browser opened and navigated to " + URL + "/notification_message_rendered");
	}

	@Test
	void notificationMessageVerification() {
		clickLinkVerifyMessages();
		logger.info("notificationMessageVerification() Test successfully passed");
	}

}
