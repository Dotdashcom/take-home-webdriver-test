package org.ithaka.portico.demo.ui.base;

import org.ithaka.portico.demo.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Base {

	public static void main(String[] args) {
		
		//Chrome driver
		
		//invoke .exe file
		//System.setProperty("webdriver.chrome.driver", "chromedriver 2");
			
		//Create driver object for chrome browser
		//Class name = ChromeDriver
		//ChromeDriver  driver = new ChromeDriver();
		
		WebDriverManager wdm = new WebDriverManager();
		WebDriver  driver = wdm.getDriver();
		
		//Go to the url
		//driver.get("http://localhost:7080/login");
		PageObjectManager pageObjectManager = new PageObjectManager(driver);
		LoginPage loginpage = pageObjectManager.getLoginPage();
		try {
			loginpage.navigateToURL("http://localhost:7080/login");
			
			
			loginpage.loginToAppSuccess("tomsmith", "SuperSecretPassword!");
			
			loginpage.loginToAppFailure("tomsmith", "SuperSecretPassword");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		// Maximize window size of browser
        //driver.manage().window().maximize();
        
		
		/*
        
		   // Enter your login email id
        driver.findElement(By.id("username"))
            .sendKeys("tomsmith");
  
        // Enter your login password
        driver.findElement(By.id("password"))
            .sendKeys("SuperSecretPassword!");
  
        //Log in
        driver.findElement(By.className("radius"))
            .click();
        
        //Log out
        driver.findElement(By.className("icon-signout"))
        .click();
        
        
		
        // Enter your login email id
        driver.findElement(By.id("username"))
            .sendKeys("tomsmith");
  
        // Enter your login password
        driver.findElement(By.id("password"))
            .sendKeys("SuperSecretPassword!");
  
        //Log in
        driver.findElement(By.className("radius"))
            .click();
        
        //Log out
        driver.findElement(By.className("icon-signout"))
        .click();
        
        Assert.assertNotNull(driver.findElement(By.id("flash")));
        
		*/
		//Close current browser
		//driver.close();
		
		//Close all the browsers
		//driver.quit();

		loginpage.closeApp();
	}

}