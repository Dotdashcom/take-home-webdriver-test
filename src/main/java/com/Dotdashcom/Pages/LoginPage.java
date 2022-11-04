package com.Dotdashcom.Pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Dotdashcom.Pages.SecurePage;
import com.Dotdashcom.GeneralPage.GeneralPage;
import com.Dotdashcom.ProxyDriver.ProxyDriver;

public class LoginPage extends GeneralPage {
	private static final String PAGE_URL = "/login";

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By inputUsernameField = By.id("username");
	private By inputPasswordField = By.id("password");
	private By login = By.cssSelector("button.radius");

	public void enterUsername(String username) {
		((ProxyDriver) wd).sendKeys(inputUsernameField, username);
	}

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(inputPasswordField, password);
	}

	public SecurePage clickSubmitBtn() {
		((ProxyDriver) wd).submit(login);
		return new SecurePage(wd, true);
	}

	@Override
	protected void isLoaded() throws Error {
		if (!urlContains(wd.getCurrentUrl())) {
			fail("Page didn't load");
		}
	}

	@Override
	public String getPageURL() {
		return String.format("%s%s", getDomain(), PAGE_URL);
	}

}
