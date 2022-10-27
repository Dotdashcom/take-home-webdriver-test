package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.takeHomeTest.Utils.ProxyDriver;

public class LoginPage extends Page {

	public LoginPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private By userNameField = By.cssSelector("input#username");
	private By passwordField = By.cssSelector("input#password");
	private By loginBtn = By.cssSelector("button.radius");
	private By loginSuccessMsg = By.cssSelector("div#flash");

	public void enterUserName(String userName) {
		((ProxyDriver) wd).sendKeys(userNameField, userName);
	}

	public void enterPassword(String password) {
		((ProxyDriver) wd).sendKeys(passwordField, password);
	}

	public void clickloginBtn() {
		((ProxyDriver) wd).click(loginBtn);
	}

	public String getTextFromloginSuccessMsg() {
		return ((ProxyDriver) wd).getText(loginSuccessMsg);
	}

}
