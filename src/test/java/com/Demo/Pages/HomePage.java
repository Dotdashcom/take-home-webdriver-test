package com.Demo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Home Page
 */
public class HomePage {
  protected WebDriver driver;

  

  public HomePage(WebDriver driver){
    this.driver = driver;
    
  }

 
  public String getActualURL() {
	String actualUrl = driver.getCurrentUrl();
    return actualUrl;
  }
  public String getExpectedURL() {
	    String expectedUrl="http://localhost:7080/secure";
	    return expectedUrl;
	  }

  public HomePage manageProfile() {
    // Page encapsulation to manage profile functionality
    return new HomePage(driver);
  }
  
}
