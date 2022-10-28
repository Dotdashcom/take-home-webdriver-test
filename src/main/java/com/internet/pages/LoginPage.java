package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.internet.utils.Proxywrapper;

public class LoginPage extends Page {

	private static final String PAGE_URL = "/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By usernameField = By.cssSelector("#username");
	private By passwordField = By.cssSelector("#password");
	private By login = By.cssSelector("button.radius");

	public void enterUsername(String username) {
		((Proxywrapper) driver).sendKeys(usernameField, username);
	}

	public void enterPassword(String password) {
		((Proxywrapper) driver).sendKeys(passwordField, password);
	}

	public SecureAreaPage clickSubmitBtn() {
		((Proxywrapper) driver).submit(login);
		return new SecureAreaPage(driver, true);
	}

}
