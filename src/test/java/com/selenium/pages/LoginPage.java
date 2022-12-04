package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.utils.DriverFactory;

public class LoginPage {
	
	private String url = "http://localhost:7080/login ";
	private By username = By.cssSelector("#username");
	private By password = By.cssSelector("#password");
	private By loginButton = By.cssSelector("[type=submit]");
	private By message = By.cssSelector("#flash");
	

	public By getMessage() {
		return message;
	}

	public String getUrl() {
		return url;
	}

	public By getUsername() {
		return username;
	}

	public By getPassword() {
		return password;
	}

	public By getLoginButton() {
		return loginButton;
	}
	
	public LoginPage login(String user, String pass) {
		WebDriver driver = DriverFactory.getDriver();
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		return this;
	}
}
