/**
 * 
 */
package tests;

/**
 * @author connorparnell
 *
 */
     
import org.openqa.selenium.WebDriver;              
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import pages.LoginPage;

public class TestLoginFailure {
	
	private WebDriver driver;
	private LoginPage login;
	// bad username
	private String username1 = "NOTtomsmith";
	private String password1 = "SuperSecretPassword!";
	// bad password
	private String username2 = "tomsmith";
	private String password2 = "NOTSuperSecretPassword!";
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		login = new LoginPage(driver);
	}
	
	@Test
	public void loginSuccess() {
		login.withCredentials(username1, password1);
		assertTrue("login has failed (test has failed).", login.isFailure());
		login.withCredentials(username2, password2);
		assertTrue("login has failed (test has failed).", login.isFailure());
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}