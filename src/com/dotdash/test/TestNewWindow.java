package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.NewWindowPage;
import com.dotdash.page.NewlyOpenedWindowPage;
import com.dotdash.util.DriverUtil;

public class TestNewWindow extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}

	@Test(description = "Test open a new window and switch to it")
	private void testNewWindow() {
		NewWindowPage firstPage = navigateTo(driver, NewWindowPage.class);
		firstPage.verifyPage();
		
		NewlyOpenedWindowPage secondPage = firstPage.openAndSwitchToNewWindow();
		secondPage.verifyPage();
	}

	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
