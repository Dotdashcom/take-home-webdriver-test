package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

public class LoginPage {

	private WebDriver driver;

	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.cssSelector(".fa-sign-in");
	private By successMessage = By.id("flash");
	private By errorMessage = By.id("flash");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(Config.getUrl("login.success"));
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

	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}

	public String getErrorMessageUsername() {
		return driver.findElement(errorMessage).getText();
	}

	public String getErrorMessagePassword() {
		return driver.findElement(errorMessage).getText();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

}
