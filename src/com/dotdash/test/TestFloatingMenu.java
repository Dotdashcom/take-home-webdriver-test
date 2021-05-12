package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.FloatingMenuPage;
import com.dotdash.util.DriverUtil;

public class TestFloatingMenu extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test menu continues to be visible when scrolling down the page")
	private void testFloatingMenu() {
		FloatingMenuPage floatingMenuPage = navigateTo(driver, FloatingMenuPage.class);
		floatingMenuPage.verifyPage();
		
		floatingMenuPage.scrollDown(250);
		floatingMenuPage.verifyPage();

		floatingMenuPage.scrollDown(250);
		floatingMenuPage.verifyPage();
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
