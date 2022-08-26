package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;

public class LoginTestFailure {

	WebDriver driver;

	@Test
	public void validUserShouldNotBeAbleToLogin() {

		driver = BrowserFactory.init();

		driver.get("http://localhost:7080/login");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("tomsmith1");
		loginPage.insertPassword("1SuperSecretPassword!");
		loginPage.clickSiginButton();

		loginPage.validateLogin();

		// closing browser
		BrowserFactory.tearDown();
	}

}
