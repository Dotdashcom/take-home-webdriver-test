package com.qa.INTest.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.INTest.Pages.LoginFailurePage;
import com.qa.INTest.TestBase.TestBase;

public class LoginFailureTest extends TestBase {

	LoginFailurePage lfp;

	public LoginFailureTest() {

		super();

	}

	@BeforeMethod
	public void setup() {

		initilize();
		lfp = new LoginFailurePage();
		lfp.clickOnFormAuthentication();
	}

	@Test
	public void vldLoginSuccess() {
		String expErrorMessage = prop.getProperty("ErrorMessage");
		System.out.println(expErrorMessage);
		String actErrorMeassage = lfp.loginWithWrongCred(prop.getProperty("WRUserName"), prop.getProperty("Password"));
		System.out.println(actErrorMeassage);
		Assert.assertNotEquals(expErrorMessage, actErrorMeassage);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
