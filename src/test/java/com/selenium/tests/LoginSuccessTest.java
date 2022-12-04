package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pages.LoginPage;
import com.selenium.pages.SecureAreaPage;

public class LoginSuccessTest extends TestBase {

	@Test
	public void loginSuccess() {

		LoginPage loginPage = new LoginPage();
		driver.get(loginPage.getUrl());
		loginPage.login("tomsmith", "SuperSecretPassword!");

		SecureAreaPage secureAreaPage = new SecureAreaPage();
		String title = driver.findElement(secureAreaPage.getTitle()).getText();
		Assert.assertEquals(title, "Secure Area");
	}
}