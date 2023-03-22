package com.test.tests;

import org.junit.jupiter.api.Test;

import com.test.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFailureTest extends TestBase {

	@Test
	public void testLoginFailure() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("invalid_username");
		loginPage.enterPassword("SuperSecretPassword!");
		loginPage.clickLoginButton();

		String errorMessage = loginPage.getErrorMessageUsername();
		assertTrue(errorMessage.contains("Your username is invalid!"));

	}

	@Test
	public void testInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("tomsmith");
		loginPage.enterPassword("invalid_password");
		loginPage.clickLoginButton();

		String errorMessage = loginPage.getErrorMessagePassword();
		assertTrue(errorMessage.contains("Your password is invalid!"));

	}
}
