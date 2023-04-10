package com.homedriver;

import dataProviders.ConfigFileReader;

import org.junit.Assert;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTests {

	private static WebDriver driver;
	private static ConfigFileReader configFileReader;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		configFileReader= new ConfigFileReader();
		driver = new ChromeDriver();
	}

	@Test
	public void loginPage_validCredentialsProvided() {
		
		
		driver.get(configFileReader.getBaseUrl() + "/login");

		// create an instance of LoginPage class.
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(configFileReader.getValidUsername(), configFileReader.getValidPassword());
		assertTrue(loginPage.isLoggedIn());
	}

	@Test
	public void loginPage_invalidCredentialsProvided() {
		driver.get(configFileReader.getBaseUrl() + "/login");

		// create an instance of LoginPage class.
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(configFileReader.getInvalidUsername(), configFileReader.getValidPassword());
		Assert.assertEquals("Your username is invalid!\n×", loginPage.getFlashError());

		loginPage.login(configFileReader.getValidUsername(), configFileReader.getInvalidPassword());
		Assert.assertEquals("Your password is invalid!\n×", loginPage.getFlashError());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
