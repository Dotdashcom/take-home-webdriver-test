package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("URL") + "login");
		loginpage = new LoginPage();
	}

	@Test (priority = 1)
    public void loginTestSucess() throws InterruptedException {
		loginpage.loginSuccessfull();
		Thread.sleep(1000);
		System.out.println(loginpage.readLoginMessage());
		Assert.assertEquals(loginpage.readLoginMessage() , prop.getProperty("loginMessage"));
	}

	@Test (priority = 2)
	public void loginTestFailure() throws InterruptedException {
		loginpage.loginFailure();
		Thread.sleep(1000);
		System.out.println(loginpage.readLoginFailureMessage());
		Assert.assertEquals(loginpage.readLoginFailureMessage() , prop.getProperty("readLoginFailureMessage"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	
	

}
