package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.DropdownPage;
import com.dotdash.util.DriverUtil;

public class TestDropdown extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test select dropdown options")
	private void testDropdown() {
		DropdownPage dropdownPage = navigateTo(driver, DropdownPage.class);
		dropdownPage.verifyPage();
		
		dropdownPage.selectByText("Option 1");
		dropdownPage.verifyPage("Option 1", "1");

		dropdownPage.selectByText("Option 2");
		dropdownPage.verifyPage("Option 2", "2");
	}
	
	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
