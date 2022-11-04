package com.Dotdashcom.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Dotdashcom.Base.TestBase;
import com.Dotdashcom.Pages.HomePage;
import com.Dotdashcom.Pages.NotificationMessagePage;

public class NotificationMessagePageTest extends TestBase {
	HomePage homePage;
	NotificationMessagePage notificationMessagePage;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		homePage = new HomePage(webdriver, true);
		notificationMessagePage = homePage.clickNotification();
	}

	@Test(invocationCount = 5)
	public void verifyNotificationMessageTest() {
		notificationMessagePage.clickLink();
		Assert.assertTrue(notificationMessagePage.expectedNotificationMessages().contains(notificationMessagePage.getTextHeader()));
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}


}
