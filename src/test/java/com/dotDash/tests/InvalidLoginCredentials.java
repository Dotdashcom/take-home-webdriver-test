package com.dotDash.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotDash.Pages.LoginPage;
import com.dotDash.basePages.BaseTest;

public class InvalidLoginCredentials extends BaseTest{
	
	//Initializing page classes
		LoginPage loginPage; 
		


		@Test
		public void Login() throws InterruptedException {
			System.out.println("Login Failure Test");
			loginPage= new LoginPage(driver);
			loginPage.loginToApp(prop.getProperty("invalidusername"), prop.getProperty("invalidpassword"));
			String actual="Your username is invalid!";
			System.out.println(loginPage.ValidateLognPageErrorMsg());
			Assert.assertEquals(actual, loginPage.ValidateLognPageErrorMsg(), "Values don't match");
		}
		
		

	}

