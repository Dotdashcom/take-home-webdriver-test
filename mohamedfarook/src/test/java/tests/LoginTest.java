package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/login");
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginSucessTest() throws InterruptedException {
		loginPage.loginSuccess("tomsmith", "SuperSecretPassword!");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.messages.getText(), "You logged into a secure area!\n" + "×");
	}

	@Test(priority = 2)
	public void loginFailUsername() throws InterruptedException {
		loginPage.loginSuccess("tommysmith", "SuperSecretPassword!");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.messages.getText(), "Your username is invalid!\n" + "×");
	}

	@Test(priority = 3)
	public void loginFailPassword() throws InterruptedException {
		loginPage.loginSuccess("tomsmith", "SuperSecretPassword123");
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.messages.getText(), "Your password is invalid!\n" + "×");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
