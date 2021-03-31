package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivertest.utils.ElementUtil;

public class DynamicControlPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public DynamicControlPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	By removeCheckboxButton = By.xpath("//*[@id='checkbox-example']/button");
    By checkBox = By.id("checkbox");
    By textField = By.xpath("//*[@id='input-example']/input");
    By disableTextFieldBtn = By.xpath("//*[@id='input-example']/button");
	
	public DynamicControlPage clickOnRemoveCheckBoxBtn() {
        driver.findElement(removeCheckboxButton).click();
        elementUtil.waitForElementVisible(checkBox);
        return this;
    }
	public boolean verifyCheckBoxIsRemoved() {
        boolean isCheckboxVisible = true;
        try {
        	elementUtil.doIsDisplayed(checkBox);
        } catch (Exception e) {
            isCheckboxVisible = false;
        }
		return isCheckboxVisible;
    }
	public DynamicControlPage clcikToEnabledTextField() {
		elementUtil.doClick(disableTextFieldBtn);
        elementUtil.waitForElementClickable(textField);
        return this;
    }
	private boolean verifyTextFieldState(boolean isEnable) {
        boolean isTextFieldIsEnabled = isEnable;
        try {
        	elementUtil.doIsEnabled(textField);
        } catch (Exception e) {
            isTextFieldIsEnabled = !isEnable;
        }
		return isTextFieldIsEnabled;
    }
	public boolean verifyTextFieldIsEnabled() {
		return verifyTextFieldState(true);
    }
	public boolean verifyTextFieldIsDisabled() {
		return verifyTextFieldState(false);
    }

}
