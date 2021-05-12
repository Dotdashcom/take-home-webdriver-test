package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.ContextMenuPage;
import com.dotdash.util.DriverUtil;

public class TestContextMenu extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test open context menu and then javascript alert box is displayed")
	private void testContextMenu() {
		ContextMenuPage contextMenuPage = navigateTo(driver, ContextMenuPage.class);
		contextMenuPage.verifyPage();
		
		contextMenuPage.openContextMenu();
		contextMenuPage.verifyAlertWindow();
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
