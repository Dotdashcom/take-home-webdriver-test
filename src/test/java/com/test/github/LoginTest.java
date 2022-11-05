package com.test.github;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pages.HomePage;
import com.test.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest{
    
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/login");
    }
 
    @Test
    public void verifyUserInfo() {
    //Creating instance of loginPage
    LoginPage loginPage = new LoginPage(driver);
	
    String loginPageTitle = loginPage.getLoginTitle();
    System.out.println(loginPageTitle);
    Assert.assertTrue(loginPageTitle.contains("Login Page"));

    loginPage.loginHome("tomsmith", "SuperSecretPassword!");

    HomePage objHomePage = new HomePage(driver);
    String homepageTitle=objHomePage.getHomePageDashboardUserName();
    //Verify home page

    //Asserting user info   
    Assert.assertTrue(homepageTitle.contains("Secure Area"));}
    
   @Test
   public void invaildCredentials() {
	   LoginPage loginPage = new LoginPage(driver);
		
	    String loginPageTitle = loginPage.getLoginTitle();
	    System.out.println(loginPageTitle);
	    Assert.assertTrue(loginPageTitle.contains("Login Page"));

	    loginPage.loginHome("invaildUser", "invaildPassword!");

	    HomePage objHomePage = new HomePage(driver);
	    String homepageTitle=objHomePage.getHomePageDashboardUserName();
	     
	    Assert.assertFalse(homepageTitle.contains("Secure Area"));
   }
    
@AfterTest
public void teardown() {
   // Close the driver
    driver.close();
}
}