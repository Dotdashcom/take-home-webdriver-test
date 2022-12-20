package com.dotdashcom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdashcom.pageobjects.HomePage;
import com.dotdashcom.pageobjects.Login;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_Login  {

	Login loginObj;
	HomePage homepage;
	
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
		homepage = new HomePage(driver);
	}
	
	@Test
	public void loginAction() {
		
		loginObj.enterUsername("tomsmith");
		loginObj.enterPassword("SuperSecretPassword!");
		
		loginObj.submitForm();

		//System.out.println("heading::"+homepage.isHeadingDisplay());
		Assert.assertTrue(homepage.isHeadingDisplay());
	}
}
