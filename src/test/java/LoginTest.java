import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.LoggedInPage;
import module.LoginPage;

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
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();		
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
		
		assertTrue("Issue logging in", loggedIn.getFlashMessage().contains("You logged into a secure area!"));
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
		
		assertTrue("Issue with invalid username", loginPage.getFlashMessage().contains("Your username is invalid!"));
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
		
		assertTrue("Issue with invalid password", loginPage.getFlashMessage().contains("Your password is invalid!"));
	}
	
	/**
	 * Clean up after test is run
	 */
	@After
	public void cleanup() {
		driver.quit();
	}

}
