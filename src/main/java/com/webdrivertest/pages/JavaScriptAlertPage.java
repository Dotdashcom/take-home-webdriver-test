package com.webdrivertest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivertest.utils.AppConstants;
import com.webdrivertest.utils.ElementUtil;

public class JavaScriptAlertPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public JavaScriptAlertPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
    By jsAlert = By.cssSelector("[onclick='jsAlert()']");
    By jsConfirm = By.cssSelector("[onclick='jsConfirm()']");
    By jsPrompt = By.cssSelector("[onclick='jsPrompt()']");
    By text_result = By.id("result");
    
    public void jsAlertClick() {
    	elementUtil.waitForElementPresent(jsAlert);
    	elementUtil.doClick(jsAlert);
    }
    public void jsConfirmClick() {
    	elementUtil.waitForElementPresent(jsConfirm);
    	elementUtil.doClick(jsConfirm);
    }
    public String alertAccept() {
    	return elementUtil.getAlertText(driver);
    }
    public void jsPromtClick() {
    	elementUtil.waitForElementPresent(jsPrompt);
    	elementUtil.doClick(jsPrompt);
    }
    public String acceptJSPrompt() {
    	return elementUtil.sendTextAlertBox(driver, AppConstants.TEXT_ALERT);
    }

}
