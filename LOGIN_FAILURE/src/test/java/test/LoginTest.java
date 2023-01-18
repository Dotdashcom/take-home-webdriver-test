package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BroserFactory;

public class LoginTest {
	WebDriver driver;
	@Test
	public void userShouldBeAbleToLogin() {
		driver=BroserFactory.launchBrowser();
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("Bitman");
		loginPage.insertPassword("SecretPasswor");
		loginPage.clickTologin();
		loginPage.assertion();
		loginPage.tearDown();
	}
      

}
