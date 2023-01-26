package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.NotificationMessagePage;

public class NotificationMessagePageTest extends TestBase {

	NotificationMessagePage notificationMessagePage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "notification_message_rendered");
		notificationMessagePage = new NotificationMessagePage();
	}

	@Test()
	public void notification() throws InterruptedException {

//		if(notificationMessagePage.linkText().contains(prop.getProperty("notification1")||prop.getProperty("notofocation2"))) {

		int i = 0;
		while (i < 5) {
			notificationMessagePage.linkclick();

			if (notificationMessagePage.matchNotification1() == true) {
				// System.out.println(prop.getProperty("notification1"));
				Assert.assertTrue(true, prop.getProperty("notification1"));
				break;
			} else if (notificationMessagePage.matchNotification2() == true) {
				// System.out.println(prop.getProperty("notification2"));
				Assert.assertTrue(true, prop.getProperty("notification2"));
				break;
			}

			i++;
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
