package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2")
	public WebElement headerLoginPage;

	
	@FindBy(css="#username")
	public WebElement usernameField;
	
	@FindBy(xpath="#password")
	public WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement buttonLogin;
	
	@FindBy(css="div#flash")
	public WebElement flasMessage;
	
	public void login(String uname, String pwd){
		
		usernameField.sendKeys(uname);
		passwordField.sendKeys(pwd);
		buttonLogin.click();
		
		
	}
	
	

}
