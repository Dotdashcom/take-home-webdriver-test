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

public class TestLoginSuccess {
	
	private WebDriver driver;
	private LoginPage login;
	private String username = "tomsmith";
	private String password = "SuperSecretPassword!";
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		login = new LoginPage(driver);
	}
	
	@Test
	public void loginSuccess() {
		login.withCredentials(username, password);
		assertTrue("login has failed (test has failed).", login.isSuccess());
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
