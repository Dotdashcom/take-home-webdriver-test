package org.ithaka.portico.demo.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		
		//Chrome driver
		
		//invoke .exe file
		System.setProperty("webdriver.chrome.driver", "chromedriver 2");
			
		//Create driver object for chrome browser
		//Class name = ChromeDriver
		ChromeDriver  driver = new ChromeDriver();
		
		/*
		
		//Implement the method of web drive
				 
		//Go to the url
		driver.get("https://www.findmyfare.com/");
				 
		//Validate your page title is correct
		System.out.println(driver.getTitle());
		
		//Validate landed url
		System.out.println(driver.getCurrentUrl());
		
		//Print page source
		System.out.println(driver.getPageSource());
		
		//Go to the url
		driver.get("https://www.airbnb.com/");
		
		
		//Navigate back
		driver.navigate().back();
		
		//Navigate forward
		driver.navigate().forward();
		
		*/
		
		
		//Go to the url
		driver.get("http://localhost:7080/login");
		
	
		// Maximize window size of browser
        driver.manage().window().maximize();
        
        
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
        
        
        
		
		//Close current browser
		//driver.close();
		
		//Close all the browsers
		//driver.quit();

	}

}