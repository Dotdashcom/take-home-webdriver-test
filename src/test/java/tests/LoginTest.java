package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import util.BrowserFactory;

public class LoginTest extends BrowserFactory {
	static LoginPage loginPage;

	@BeforeMethod
	public static void beforeTests() {
		init("login");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority = 1)
	public static void testIsAbleToLoginSuccessfullyAndValidatingTheLoginIsSuccessful() {
		loginPage.loginWithValidUsernameAndPassword();
		loginPage.clickLoginButton();
		loginPage.validateLoginIsSuccessful();
	}

	@Test(priority = 2)
	public static void testIsNotAbleToLoginWithInvalidUsername() {
		loginPage.loginWithInvalidUsername();
		loginPage.clickLoginButton();
		loginPage.validateLoginIsFailureForInvalidUsername();

	}

	@Test(priority = 3)
	public static void testIsNotAbleToLoginWithInvalidPassword() {
		loginPage.loginWithInvalidPassword();
		loginPage.clickLoginButton();
		loginPage.validateLoginIsFailureForInvalidPassword();

	}

	@AfterMethod
	public static void afterTests() {
		tearDown();
	}

}
