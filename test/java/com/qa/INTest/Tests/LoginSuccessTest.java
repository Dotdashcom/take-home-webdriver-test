package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.LoginSuccessPage;
import com.qa.INTest.TestBase.TestBase;

public class LoginSuccessTest extends TestBase {

	LoginSuccessPage lsp;

	public LoginSuccessTest() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initilize();
		lsp = new LoginSuccessPage();
		lsp.clickOnFormAuthentication();
	}

	@Test
	public void vldLoginSuccess() {

		boolean flag = lsp.loginWithCorrectCred(prop.getProperty("UserName"), prop.getProperty("Password"));
		Assert.assertTrue(flag, "User has loged in.");

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
