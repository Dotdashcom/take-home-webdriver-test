package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DynamicLoadingPage1;
import com.dotdash.page.DynamicLoadingPage2;
import com.dotdash.util.DriverUtil;

public class TestDynamicLoading extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test loading dynamic text which is just hiding in HTML DOM")
	private void testDynamicTextHidingInDOM() {
		DynamicLoadingPage1 dynamicLoadingPage1 = navigateTo(driver, DynamicLoadingPage1.class);
		dynamicLoadingPage1.verifyPage();

		dynamicLoadingPage1.loadDynamicText();
		dynamicLoadingPage1.verifyPage(false, true);
	}
	
	@Test(description = "Test loading dynamic text which is adding to HTML DOM")
	private void testDynamicTextAddingToDOM() {
		DynamicLoadingPage2 dynamicLoadingPage2 = navigateTo(driver, DynamicLoadingPage2.class);
		dynamicLoadingPage2.verifyPage();

		dynamicLoadingPage2.loadDynamicText();
		dynamicLoadingPage2.verifyPage(false, true);
	}

	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
