package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPg;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization("/login");
		loginPg = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginSuccessTest() {
		loginPg.login(prop.getProperty("validUsername"),prop.getProperty("validPassword"));
		boolean b = loginPg.validateSuccessMsg();
		Assert.assertTrue(b, "Test case is passed");
	}
	
	@Test(priority = 2)
	public void loginFailureTest() {
		loginPg.login(prop.getProperty("invalidUsername"),prop.getProperty("invalidPassword"));
		boolean b = loginPg.validateFailureMsg();
		Assert.assertTrue(b, "Test case is passed");
	}
}
