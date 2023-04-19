package com.qa.dotdash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dotdash.factory.BaseClass;
import com.qa.dotdash.pages.HomePage;
import com.qa.dotdash.pages.NotificationMessagePage;

public class NotificationMessagePageTest extends BaseClass {
	HomePage homePage;
	NotificationMessagePage notification;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		notification = homePage.clickNotification();
	}

	@Test(invocationCount = 5)
	public void verifyNotificationMessageTest() {
		notification.clickLink();
		Assert.assertTrue(notification.expectedNotificationMessages().contains(notification.getTextHeader()));
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}


}
