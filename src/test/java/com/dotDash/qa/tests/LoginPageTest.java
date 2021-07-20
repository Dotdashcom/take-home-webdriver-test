package com.dotDash.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.qa.base.TestBase;
import com.dotDash.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "The Internet");
	}

	@Test(priority = 2)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		String success = loginPage.sucess();
		// String expected = "You logged into a secure area!";
		// Assert.assertEquals(expected , success );
	}

	@Test(priority = 3)
	public void loginFailTest() {
		loginPage.login("Test", "Test");
		String fail = loginPage.fail();
		// Assert.assertEquals("Your username is invalid!", fail );
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
