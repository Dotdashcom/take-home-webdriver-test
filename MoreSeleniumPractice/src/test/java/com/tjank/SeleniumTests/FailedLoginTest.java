package com.tjank.SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.InternetLoginPage;
import com.tjank.PageObjectModel.WebPage;

public class FailedLoginTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test 
	public void unhappyPathLogin() {
		InternetLoginPage loginPage = new InternetLoginPage();
		loginPage.setup();
		loginPage.waitForPageToLoad();
		loginPage.login("bad", "pass");
		loginPage.waitForLoginToFail();
		Assert.assertTrue(loginPage.getLoginFailedMessage().contains("Your username is invalid!"));
	}
	
}
