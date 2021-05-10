package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DynamicControlsPage;
import com.dotdash.util.DriverUtil;

public class TestDynamicControls extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test toggle elements back-and-forth")
	private void testDynamicControls() {
		DynamicControlsPage dynamicControlsPage = navigateTo(driver, DynamicControlsPage.class);
		dynamicControlsPage.verifyPage();

		dynamicControlsPage.toggleCheckbox(false);
		dynamicControlsPage.verifyPage(false, false);
		
		dynamicControlsPage.toggleCheckbox(true);
		dynamicControlsPage.verifyPage(true, false);

		dynamicControlsPage.toggleInputbox(true);
		dynamicControlsPage.verifyPage(true, true);

		dynamicControlsPage.toggleInputbox(false);
		dynamicControlsPage.verifyPage(true, false);
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
