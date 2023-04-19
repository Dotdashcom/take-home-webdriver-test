package com.qa.dotdash.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dotdash.utils.Proxywrapper;

public class LoginPage extends Page {

	private static final String PAGE_URL = "/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By usernameField = By.cssSelector("#username");
	private By passwordField = By.cssSelector("#password");
	private By login = By.cssSelector("button.radius");

	public void inputUsername(String username) {
		((Proxywrapper) driver).sendKeys(usernameField, username);
	}

	public void inputPassword(String password) {
		((Proxywrapper) driver).sendKeys(passwordField, password);
	}

	public SecureAreaPage clickSubmitButton() {
		((Proxywrapper) driver).submit(login);
		return new SecureAreaPage(driver, true);
	}
}
