package dotdash.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dotdash.resources.base;
import dotdash.pageobjects.*;


public class LoginTest extends base {
	
	public WebDriver driver;
	LoginPage l;
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("loginUrl"));
		
	}
	
	
	@Test
	public void validatelogin() throws IOException, InterruptedException {		
					
			 l= new LoginPage(driver);
			 l.LoginToApp("tomsmith", "SuperSecretPassword!");
			 HomePage homepage = new HomePage(driver);
			 AssertJUnit.assertTrue(homepage.getSuccessMessage().isDisplayed());
			
		
	}
	
	@Test
	public void validateIncorrectlogin() throws IOException, InterruptedException {		
			 l= new LoginPage(driver);
			 l.LoginToApp("tomsmith", "SuperSecretPasswo");
			 AssertJUnit.assertTrue(l.getErrorMessage().isDisplayed());
			
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	

}
