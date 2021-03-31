package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivertest.utils.AppConstants;
import com.webdrivertest.utils.Credentials;
import com.webdrivertest.utils.ElementUtil;


public class LoginPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	/**
	 * Constructor
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	/**
	 * Locators
	 */
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//button[@type='submit']");
	By flashMessage = By.id("flash");
	/**
	 * PageTitle		
	 * @return
	 */
	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public void doLogin(Credentials userCred) {
		elementUtil.waitForElementPresent(username);
		elementUtil.doSendKeys(username, userCred.getAppUsername());
		elementUtil.waitForElementPresent(password);
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		elementUtil.waitForElementPresent(loginButton);
		elementUtil.doClick(loginButton);
	}
	
	public String getText() {
		elementUtil.waitForElementPresent(flashMessage);
		return elementUtil.doGetText(flashMessage);
	}

}
