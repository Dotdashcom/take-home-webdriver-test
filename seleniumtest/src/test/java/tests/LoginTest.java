package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.LoginPage;

public class LoginTest extends GenericPage {
	LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/login");
		loginPage = new LoginPage();
	}

	@Test
	public void tc1LoginSuccess() throws InterruptedException {
		loginPage.login("tomsmith", "SuperSecretPassword!");
		Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!\n×");
	}

	@Test
	public void tc2LoginFailure() throws InterruptedException {
		loginPage.login("username", "password");
		Assert.assertEquals(loginPage.getMessage(), "Your username is invalid!\n×");
	}

}