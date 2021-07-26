package com.dotDash.qa.tests;

import org.openqa.selenium.By;
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

	// Testing and asserting the value
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "The Internet");
	}

	// Testing and asserting the value
	@Test(priority = 2)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String success = driver.findElement(By.className("subheader")).getText(); 
		Assert.assertEquals(success, "Welcome to the Secure Area. When you are done click logout below.");
	}

	// Testing and asserting the value
	@Test(priority = 3)
	public void loginFailTest() {
		loginPage.login("Test", "Test");
		String fail = loginPage.fail();
		String flash = fail.substring(0, fail.length() - 1).trim();
		Assert.assertEquals(flash, "Your username is invalid!");
	}

	// Testing and asserting the value
	@Test(priority = 4)
	public void loginFailTestWithWrongUserName() {
		loginPage.login("Test", prop.getProperty("password"));
		String fail = loginPage.fail();
		String flash = fail.substring(0, fail.length() - 1).trim();
		Assert.assertEquals(flash, "Your username is invalid!");
	}

	@Test(priority = 5)
	public void loginFailTestWithWrongPassword() {
		loginPage.login(prop.getProperty("username"), "Test");
		String fail = loginPage.fail();
		String flash = fail.substring(0, fail.length() - 1).trim();
		Assert.assertEquals(flash, "Your password is invalid!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
