package Testing.AutomationTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.base;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class loginTest extends base {
public WebDriver driver;
LoginPage login; 
HomePage homepage;

@BeforeMethod
		public void initialize() throws IOException {
			driver= initializeDriver();		
			driver.get(prop.getProperty("loginUrl"));
		}

		@Test
		public void validLogin() throws IOException, InterruptedException {
			login = new LoginPage(driver);
			homepage = new HomePage(driver);
			login.LogintoApp("tomsmith", "SuperSecretPassword!");
				  homepage = new HomePage(driver);
				 AssertJUnit.assertTrue(homepage.getSuccessMessage().isDisplayed());
		}
		@Test
		public void validateInvalidlogin() throws IOException, InterruptedException {
			login = new LoginPage(driver);
			login.LogintoApp("tomsmith", "SuperSecretPassword");
				 AssertJUnit.assertTrue(login.getErrorMessage().isDisplayed());
		}

		@AfterMethod
		public void closeBrowser() {

			driver.close();
		}

	}

