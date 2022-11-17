package com.dotdash.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.BaseClass.BaseClass;
import com.dotdash.Pages.InternetPage;
import com.dotdash.Pages.NotificationMessagePage;

public class NotificationMessagePageTest extends BaseClass {
	InternetPage internet;
	NotificationMessagePage notification;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		internet = new InternetPage(webdriver, true);
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
