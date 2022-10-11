package com.tjank.SeleniumTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.NotificationMessagePage;
import com.tjank.PageObjectModel.WebPage;

public class NotificationTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void notificationTest() {
		NotificationMessagePage notPage = new NotificationMessagePage();
		notPage.setup();
		notPage.waitForPageToLoad();
		notPage.clickLink();
		notPage.verifyNotificationMessage();
	}
}
