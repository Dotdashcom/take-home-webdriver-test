package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.NotificationPage;
import com.dotdash.util.DriverUtil;

public class TestNotification extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}

	@Test(description = "Test notification message is displayed when clicking the link")
	private void testNotification() {
		NotificationPage notificationPage1 = navigateTo(driver, NotificationPage.class);
		notificationPage1.verifyPage();
		
		NotificationPage notificationPage2 = notificationPage1.loadNewNotificationMessage();
		notificationPage2.verifyPage(true);
	}

	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
