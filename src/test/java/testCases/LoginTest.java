package testCases;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class LoginTest extends BaseTest{
	@Test
	public void sucessLogin() {	
		HomePage homepage = new HomePage(driver);
		LoginPage login = homepage.clickAuthenticationLink();
		login.login("tomsmith", "SuperSecretPassword!");
		assertTrue(login.loginMessges().contains("You logged into a secure area!"));
	}
	
	@Test
	public void failedLogin() {
		HomePage homepage = new HomePage(driver);
		LoginPage login = homepage.clickAuthenticationLink();
		login.login("tomsmith", "wrong");
		assertTrue(login.loginMessges().contains("Your password is invalid!"));	
	}	

}
