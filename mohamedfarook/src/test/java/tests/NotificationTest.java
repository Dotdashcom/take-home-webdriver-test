package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.NotificationPage;

public class NotificationTest extends BaseClass {
	NotificationPage notifyPageObj;

	public NotificationTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/notification_message_rendered");
		notifyPageObj = new NotificationPage();
	}

	@Test
	public void notificationTest() throws InterruptedException {
		notifyPageObj.clickButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(notifyPageObj.Message.getText(), "Action unsuccesful, please try again\n" + "×");
		notifyPageObj.clickButton.click();
		notifyPageObj.clickButton.click();
		notifyPageObj.clickButton.click();
		Thread.sleep(3000);
		Assert.assertEquals(notifyPageObj.Message.getText(), "Action successful\n" + "×");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
