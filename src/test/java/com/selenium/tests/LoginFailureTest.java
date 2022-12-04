package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pages.LoginPage;

public class LoginFailureTest extends TestBase {

	@Test
	public void wrongPass() {

		LoginPage loginPage = new LoginPage();
		driver.get(loginPage.getUrl());
		loginPage.login("tomsmith", "WrongSecretPassword!");
		String msg = driver.findElement(loginPage.getMessage()).getText();
		Assert.assertTrue(msg.contains("Your password is invalid!"));
	}

	@Test
	public void wrongUser() {

		LoginPage loginPage = new LoginPage();
		driver.get(loginPage.getUrl());
		loginPage.login("wrongusername", "SuperSecretPassword!");
		String msg = driver.findElement(loginPage.getMessage()).getText();
		Assert.assertTrue(msg.contains("Your username is invalid!"));
	}
}