package com.tjank.SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tjank.PageObjectModel.InternetLoginPage;
import com.tjank.PageObjectModel.SecurePage;
import com.tjank.PageObjectModel.WebPage;

public class LoginTest {

	@AfterMethod
	public void tearDown() {
		WebPage.tearDown();
	}
	
	@Test
	public void happyPathLogin() {
		InternetLoginPage loginPage = new InternetLoginPage();
		loginPage.setup();
		loginPage.waitForPageToLoad();
		loginPage.login("tomsmith", "SuperSecretPassword!");
		SecurePage securePage = new SecurePage();
		securePage.waitForSuccesfulLogin();
		Assert.assertEquals(securePage.getSecureText(), "Welcome to the Secure Area. When you are done click logout below.");
		securePage.clickLogoutButton();
	}
	
}