package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utils.Constants;

public class LoginSuccess extends Constants {
	static String url = "http://localhost:7080/login";
	static String validUsername = "tomsmith";
	static String validPassword = "SuperSecretPassword!";

	static String invalidUsername = "tom";
	static String invalidPassword = "123";
	static String expUrl = "http://localhost:7080/secure";


	@Test
	public static void testLoginSuccess() {

		driver.get(url);
		LoginPage loginObj = new LoginPage(driver);
		loginObj.enterUsername(validUsername);
		loginObj.enterPassword(validPassword);
		loginObj.clickLogin();
		
		String actUrl = driver.getCurrentUrl();
		sa.assertEquals(actUrl, expUrl);
		sa.assertAll();
	}



}
