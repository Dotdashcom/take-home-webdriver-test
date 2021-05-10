package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.HoversPage;
import com.dotdash.util.DriverUtil;

public class TestHovers extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test hovers on images to make captions to display")
	private void testInternalFrame() {
		HoversPage hoversPage = navigateTo(driver, HoversPage.class);
		hoversPage.verifyPage();
		
		for (int i = 0; i < 3; i++) {
			hoversPage.hoverOnFigure(i);
			boolean[] captionVisible = new boolean[] {false, false, false};
			captionVisible[i] = true;
			hoversPage.verifyPage(captionVisible);
		}
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
