package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.CheckboxesPage;
import com.dotdash.util.DriverUtil;

public class TestCheckboxes extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test check and uncheck checkboxes")
	private void testCheckboxes() {
		CheckboxesPage checkboxesPage = navigateTo(driver, CheckboxesPage.class);
		checkboxesPage.verifyPage();
		
		checkboxesPage.clickAllCheckboxes();
		checkboxesPage.verifyPage(new boolean[] {true, false});
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
