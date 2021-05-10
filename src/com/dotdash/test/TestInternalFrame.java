package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.InternalFramePage;
import com.dotdash.util.DriverUtil;

public class TestInternalFrame extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test typing inside an iframe")
	private void testInternalFrame() {
		InternalFramePage iframePage = navigateTo(driver, InternalFramePage.class);
		iframePage.verifyPage();
		
		iframePage.typeOnEditor("typing new text");
		iframePage.verifyEditorText("typing new text");
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
