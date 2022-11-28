package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basetest.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class FaliureLoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public FaliureLoginPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void launchApp() {
		driver.get(prop.getProperty("loginURL"));
	}

	@Test(priority = 2)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "The Internet");
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("invalidUsername"), prop.getProperty("invalidPassword"));
	}

	@Test(priority = 5)
	public void verifyErrorMessage() {
		String errorMsg = loginPage.validateErrorMessage();
		Assert.assertEquals(errorMsg, "Your username is invalid!\n" + "×");//Assert
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
