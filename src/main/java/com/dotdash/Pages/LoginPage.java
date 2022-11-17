package com.dotdash.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ProxyDriver;

public class LoginPage extends Page {

	private static final String PAGE_URL = "/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By inputUsernameField = By.id("username");
	private By inputPasswordField = By.id("password");
	private By login = By.cssSelector("button.radius");

	public void enterUsername(String username) {
		((ProxyDriver) driver).sendKeys(inputUsernameField, username);
	}

	public void enterPassword(String password) {
		((ProxyDriver) driver).sendKeys(inputPasswordField, password);
	}

	public SecurePage clickSubmitBtn() {
		((ProxyDriver) driver).submit(login);
		return new SecurePage(driver, true);
	}

}
