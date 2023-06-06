package com.dotDash.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.Pages.LoginPage;
import com.dotDash.basePages.BaseTest;

public class LogInPageTest extends BaseTest{
	
	//Initializing page classes
	LoginPage loginPage;
	


	@Test
	public void Login() {
		loginPage = new LoginPage(driver);
		loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login Success test");
		String actual="Welcome to the Secure Area. When you are done click logout below.";
		Assert.assertEquals(actual, loginPage.verifyLandingPageTitile(), "Values don't match");
	}
	
	

}
