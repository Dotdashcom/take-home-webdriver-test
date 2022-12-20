package com.dotdashcom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdashcom.pageobjects.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_FailedLogin {

	Login loginObj;
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void initialize(){		
		loginObj = new Login(driver);
	}
	
	@Test
	public void inValidLoginAction() {
		
		loginObj.enterUsername("invalid_username");
		loginObj.enterPassword("invalid_password");
		loginObj.submitForm();		
			
		Assert.assertTrue(driver.getPageSource().contains("invalid"));
	}
}
