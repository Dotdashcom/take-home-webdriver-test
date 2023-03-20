package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Util {
	
	protected WebDriver driver;
	
	// selectors
	private By loginLink = By.linkText("Form Authentication");
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");
    
    /**
     * initiate driver
     * @param driver
     */
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void openLoginForm() {
        driver.findElement(loginLink).click();
    }
	public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    public void doLogin(String username, String password) {
    	openLoginForm();
    	enterUsername(username);
    	enterPassword(password);
    	clickLoginButton();
    }
    
}
