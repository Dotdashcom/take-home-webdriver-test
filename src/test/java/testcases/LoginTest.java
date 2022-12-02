package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.TestBase;

public class LoginTest {
	WebDriver driver;
	LoginPage loginPage;

	@Test(priority = 1, description = "Login :: Success")
	public void loginSuccess() {
		loginPage.loginToApp("tomsmith", "SuperSecretPassword!");
		boolean actual = loginPage.isHeaderDisplayed();
		Assert.assertEquals(actual, true);
		loginPage.logout();
	}

	@Test(priority = 2, description = "Login with Invalid Password :: Unsuccess")
	public void LoginUnsuccessful_001() {
		loginPage.loginToApp("tomsmith", "test");
		boolean actual = loginPage.isHeaderDisplayed();
		Assert.assertEquals(actual, false);
		Assert.assertEquals(loginPage.getErrorText(), "Your password is invalid!\n" + "×");
	}

	@Test(priority = 3, description = "Login with Invalid Username :: Unsuccess")
	public void LoginUnsuccessful_002() throws IOException {
		loginPage.loginToApp("test", "SuperSecretPassword!");
		boolean actual = loginPage.isHeaderDisplayed();
		Assert.assertEquals(actual, false);
		Assert.assertEquals(loginPage.getErrorText(), "Your username is invalid!\n" + "×");
	}

	@Test(priority = 4, description = "Login with Invalid Username and Password :: Unsuccess")
	public void LoginUnsuccessful_003() throws IOException {
		loginPage.loginToApp("test", "test!");
		boolean actual = loginPage.isHeaderDisplayed();
		Assert.assertEquals(actual, false);
		Assert.assertEquals(loginPage.getErrorText(), "Your username is invalid!\n" + "×");
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		loginPage = new LoginPage(driver);
		loginPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}