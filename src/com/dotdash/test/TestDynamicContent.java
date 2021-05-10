package com.dotdash.test;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DynamicContentPage;
import com.dotdash.util.DriverUtil;

public class TestDynamicContent extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test reloading a page and seeing different content")
	private void testDynamicContent() {
		DynamicContentPage dynamicContentPage = navigateTo(driver, DynamicContentPage.class);
		dynamicContentPage.verifyPage();
		
		int hashcodePrevious = dynamicContentPage.hashCode();
		for (int i = 0; i < 3; i++) {
			dynamicContentPage = dynamicContentPage.reload();
			dynamicContentPage.verifyPage();
			int hashCodeCurrent = dynamicContentPage.hashCode();
			assertNotEquals(hashCodeCurrent, hashcodePrevious);
			hashcodePrevious = hashCodeCurrent;
		}
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
