package com.automation.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pageobject.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginSuccess() {
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage.validateLoginHeader(driver);
		LoginPage.Login(driver, "tomsmith", "SuperSecretPassword!");
		LoginPage.validateLogedinMSG(driver);
	}
	
	@Test
	public void LoginFailure() {
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage.validateLoginHeader(driver);
		LoginPage.Login(driver, "abcd", "XOSSNNkk33k@#");
		LoginPage.validateUserNameInvalidMSG(driver);
	}
	
	
}
