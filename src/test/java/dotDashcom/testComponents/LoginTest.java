package dotDashcom.testComponents;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



import dotDashcom.pageObjects.LoginPage;


public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	
	@Before
	public void setup() throws IOException {
		setup("/login");
		loginPage=new LoginPage(driver);
	}

	@Test
	public void loginSucessCheck() {
		
		loginPage.login("tomsmith", "SuperSecretPassword!");
		String successMessage= loginPage.checkLoginMessage();
		System.out.println(successMessage);
		Assert.assertEquals(successMessage, "You logged into a secure area!");
		
	}
	
	
	
	@Test
	public void loginFailureCheck() {
		loginPage.login("snaziatanveer", "password");
		String failMessage= loginPage.checkLoginMessage();
		System.out.println(failMessage);
		Assert.assertEquals(failMessage, "Your username is invalid!");
	}
	
}
