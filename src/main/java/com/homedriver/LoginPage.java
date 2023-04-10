package com.homedriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//webDriver interface: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
	private final WebDriver driver;
	
	// element locators
    By pageHeaderLocator = By.xpath("//*[@id='content']/div/h2");
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginBtnLocator = By.xpath("//*[@id='login']/button");
    By logoutBtnLocator = By.xpath("//a[@href='/logout']");
    By flashErrorLocator = By.xpath("//*[@id='flash']");
    
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		//making sure we are on the login page.Not necessary.
		if (!"Login Page".equals(driver.findElement(pageHeaderLocator).getText())) {
            throw new IllegalStateException("This is not the Login page");
        }
	}
	
	//Method to log into the web page using the credentials provided.
	public void login(String username, String password) {
		driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginBtnLocator).click();
	}
	
	//Method to check if the credentials successful to log into the page
	 public boolean isLoggedIn() {
	        return driver.findElements(logoutBtnLocator).size() == 1;
	 }
	 
	 //get the flash error message element when wrong credentials provided.
	 public String getFlashError() {
		 return driver.findElement(flashErrorLocator).getText();
	 }
}
