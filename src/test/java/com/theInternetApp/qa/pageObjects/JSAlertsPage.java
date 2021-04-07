package com.theInternetApp.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class JSAlertsPage extends BaseClass {

	// The following Initialization of the Page factory
	public JSAlertsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// The following are Declaration the web elements

	@FindBy(xpath = "//a[contains(text(),'JavaScript Alerts')]")
	@CacheLookup
	WebElement JavaScriptAlertsLink;

	@FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
	@CacheLookup
	WebElement JSAlertButton;

	// The following are the Utilizations by creating methods for each of the
	// components.

	// get URL
	public void getUrl() {
		driver.get(Base_URL);
		JavaScriptAlertsLink.click();
	}

	// handle Allert
	public void clickOnJSAlertButton() {
		JSAlertButton.click();
		Alert Alart = driver.switchTo().alert();
		String AlertText = Alart.getText();
		Assert.assertEquals("I am a JS Alert", AlertText);
		Alart.accept();
	}

}
