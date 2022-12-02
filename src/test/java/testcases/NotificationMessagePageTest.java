package testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.NotificationMessagePage;
import testbase.TestBase;

public class NotificationMessagePageTest {

	NotificationMessagePage notificationMessagePage;
	WebDriver driver;

	@Test(description = "Different Notification messages is displayed onClick")
	public void notificationMessagesTest() {
		ArrayList<String> notificationsList = new ArrayList<String>();
		notificationsList.add("Action successful");
		notificationsList.add("Action unsuccesful, please try again");
		notificationsList.add("Action unsuccessful");

		Boolean isValidNotificationDisplayed = true;
		for (int i = 0; i < 5; i++) {
			notificationMessagePage.clickLink();
			isValidNotificationDisplayed = notificationsList
					.contains(notificationMessagePage.getNotificationMessagesOnClick());
			Assert.assertTrue(isValidNotificationDisplayed);
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		notificationMessagePage = new NotificationMessagePage(driver);
		notificationMessagePage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
