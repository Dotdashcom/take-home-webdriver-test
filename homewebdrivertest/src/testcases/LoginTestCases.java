package testcases;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

 import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.SecurePage;

public class LoginTestCases {
	
	private WebDriver browser;

	private LoginPage loginPage;
	private SecurePage securePage;
	
	private String username = "tomsmith";
	private String password = "SuperSecretPassword!";
	
	private String wrongUsername = "imnottomsmith";
	private String wrongPassword = "wrongpassword!";
	
	private String secureMessage =  "You logged into a secure area!";
	private String wrongUsernameMessage =  "Your username is invalid!";
	private String wrongPasswordMessage =  "Your password is invalid!";
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		loginPage = new LoginPage(browser);
		securePage = new SecurePage(browser);
		browser.manage().window().maximize();
	}
	
	@Test
	public void login_success() {
		loginPage.goToPage();
		loginPage.login(username, password);
		assertEquals(securePage.getUrl(), browser.getCurrentUrl(), "Wrong page. Should be at the Secure Area.");
		assertTrue(securePage.getFlashMessage().contains(secureMessage), "Wrong message.");
	}

	@Test
	public void login_wrong_username() {
		loginPage.goToPage();
		loginPage.login(wrongUsername, password);
		assertEquals(loginPage.getUrl(), browser.getCurrentUrl(), "Wrong page. Should be at the Login Area.");
		assertTrue(loginPage.getFlashMessage().contains(wrongUsernameMessage), "Wrong message.");
	}
	
	@Test
	public void login_wrong_password() {
		loginPage.goToPage();
		loginPage.login(username, wrongPassword);
		assertEquals(loginPage.getUrl(), browser.getCurrentUrl(), "Wrong page. Should be at the Login Area.");
		assertTrue(loginPage.getFlashMessage().contains(wrongPasswordMessage), "Wrong message.");
	}
	
	@Test
	public void login_wrong_username_and_password() {
		loginPage.goToPage();
		loginPage.login(wrongUsername, wrongPassword);
		assertEquals(loginPage.getUrl(), browser.getCurrentUrl(), "Wrong page. Should be at the Login Area.");
		assertTrue(loginPage.getFlashMessage().contains(wrongUsernameMessage), "Wrong message.");
	}

	@AfterEach
	public void exit() {
		browser.quit();
	}
}