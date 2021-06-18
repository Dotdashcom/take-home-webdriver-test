import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoggedInPage;
import pages.LoginPage;

/**
 * Test the login functions
 * @author CLazaruk
 *
 */
public class LoginTest {
	
	private WebDriver driver = null;
	
	/**
	 * Initialize the driver
	 */
	@Before
	public void init() {		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	/**
	 * User logs in with valid user name and password
	 * Confirm user sees expected text
	 */
	@Test
	public void loginSuccesfully() {
		LoginPage loginPage = new LoginPage(driver);
		LoggedInPage loggedIn = loginPage
				.typeUserName("tomsmith")
				.typePassword("SuperSecretPassword!")
				.clickLogin();
		
		assertTrue(loggedIn.getFlashMessage().contains("You logged into a secure area!"));
		loggedIn.clickLogout();
	}
	
	/**
	 * User attempts to log in with invalid user name
	 */
	@Test
	public void loginWithInvalidUsername() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeUserName("notTomSmith")
			.typePassword("SuperSecretPassword!")
			.clickLoginWithInvalidCredentials();		
		
		assertTrue(loginPage.getFlashMessage().contains("Your username is invalid!"));
	}
	
	/**
	 * User attempts to log in with invalid password
	 */
	@Test
	public void loginWithInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.typeUserName("tomsmith")
			.typePassword("wrongpassword!")
			.clickLoginWithInvalidCredentials();		
		
		assertTrue(loginPage.getFlashMessage().contains("Your password is invalid!"));
	}
	
	/**
	 * Clean up after test is run
	 */
	@After
	public void cleanup() {
		driver.quit();
	}

}
