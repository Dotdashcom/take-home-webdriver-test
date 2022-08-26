package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;


public class LoginTestSuccess {
	
	WebDriver driver;
	
	@Test
	public void validUserShouldBeAbleToLogin()   {
		
		driver = BrowserFactory.init();
		
		driver.get("http://localhost:7080/login");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("tomsmith");
		loginPage.insertPassword("SuperSecretPassword!");
		loginPage.clickSiginButton();
		
		loginPage.validateLogin();
		
		
	}

}
