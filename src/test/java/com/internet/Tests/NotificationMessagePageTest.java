package com.internet.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internet.base.Baseclass;
import com.internet.pages.NotificationMessagePage;
import com.internet.pages.TheInternetPage;

public class NotificationMessagePageTest extends Baseclass {
	TheInternetPage internet;
	NotificationMessagePage notification;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new TheInternetPage(webdriver, true);
		notification = internet.clickNotification();
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
