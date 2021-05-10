package com.dotdash.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.page.LoginPage;
import com.dotdash.page.SecureAreaPage;
import com.dotdash.util.DriverUtil;
import com.dotdash.util.Settings;

public class TestLogin extends AbstractWebDriverTest {

	protected ChromeDriver driver;

	@BeforeMethod
	private void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test(description = "Test login success and land on secure area")
	private void testLoginSuccess() {
		LoginPage loginPage = navigateTo(driver, LoginPage.class);
		loginPage.verifyPage();
		
		SecureAreaPage secureAreaPage = loginPage.login(Settings.getUserName(), Settings.getPassword());
		secureAreaPage.verifyPage();
	}
	
	@Test(description = "Test login failure with wrong user name")
	private void testLoginFailureWrongUserName() {
		LoginPage loginPage = navigateTo(driver, LoginPage.class);
		loginPage.verifyPage();
		
		loginPage = loginPage.loginAndExpectFailure("", Settings.getPassword());
		loginPage.verifyLoginFailure();
	}
	
	@Test(description = "Test login failure with wrong password")
	private void testLoginFailureWrongPassword() {
		LoginPage loginPage = navigateTo(driver, LoginPage.class);
		loginPage.verifyPage();
		
		loginPage = loginPage.loginAndExpectFailure(Settings.getUserName(), "");
		loginPage.verifyLoginFailure();
	}

	@AfterMethod
	private void tearDown() {
		DriverUtil.closeBrowserWindow(driver);
	}
}
