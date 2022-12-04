package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import baseTest.AbstractE2E;

public class LoginTest extends AbstractE2E{
	WebDriver driver;
	LoginPage loginPage;

	int timeoutInSeconds = 5;

	long millis = 100;

	@Test(description = "Login :: Success")
	public void TC01_Valid_UserNameAndPassword_login_Success() {
		loginPage.login("tomsmith", "SuperSecretPassword!");
		boolean actual = loginPage.isHeaderDisplayed(millis);
		Assert.assertEquals(actual, true);
		loginPage.logout();
	}

	@Test(description = "Login with Invalid Password :: Failure")
	public void TC02_invalidPassword_login_failed() {
		loginPage.login("tomsmith", "test");
		Assert.assertTrue(loginPage.getErrorMessage().contains( "Your password is invalid!"));
	}

	@Test(description = "Login with Invalid Username :: Failure")
	public void TC03_invalidUserName_login_failed() throws IOException, InterruptedException {
		loginPage.login("test", "SuperSecretPassword!");
		Assert.assertEquals(loginPage.getErrorMessage().contains( "Your username is invalid!"), true);
	}

	@Test(description = "Login with Invalid Username and Password :: Failure")
	public void TC04_invalid_UserNameAndPassword_login_failed() throws IOException {
		loginPage.login("test", "test!");
		Assert.assertEquals(loginPage.getErrorMessage().contains( "Your username is invalid!"), true);
	}

	@Test(description = "Login with Invalid Username and Password - Header check :: Failure")
	public void TC05_invalid_UserNameAndPassword_login_failedWithNoHeader() throws IOException {
		loginPage.login("blah", "test!");
		Assert.assertEquals(loginPage.getErrorMessage().contains( "Your username is invalid!"), true);
		boolean actual = loginPage.isHeaderDisplayed(millis);
		Assert.assertEquals(actual, false);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getInstance();
		loginPage = new LoginPage(driver);
		loginPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}