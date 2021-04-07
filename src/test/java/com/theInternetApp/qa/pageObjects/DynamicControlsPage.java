package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theInternetApp.qa.Utilities.BaseClass;
import com.theInternetApp.qa.Utilities.WaitHelper;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class DynamicControlsPage extends BaseClass {

	// The following Initialization of the Page factory
		public DynamicControlsPage(WebDriver driver) {

			PageFactory.initElements(driver, this);
			waitHelper = new WaitHelper(driver);
		}

		// The following are Declaration the web elements

		@FindBy(xpath = "//a[contains(text(),'Dynamic Controls')]")
		@CacheLookup
		WebElement DynamicControlsLink;
		
		@FindBy(xpath = "//button[contains(text(),'Remove')]")
		@CacheLookup
		WebElement RemoveButton;

		@FindBy(xpath = "//button[contains(text(),'Enable')]")
		@CacheLookup
		WebElement EnableButton;

		@FindBy(id = "message")
		@CacheLookup
		WebElement textMessage;

		// The following are the Utilizations by creating methods for each of the
		// components.

		// get URL
		public void getUrl() {
			driver.get(Base_URL);
			DynamicControlsLink.click();
		}

		//click on remove button and wait for the messes to appear
		public void clickOnRemoveButton() {
			RemoveButton.click();
			waitHelper.WaitForElement(textMessage, 30);
		}
		//get message after wait for remove button
		public String getMessageText() {
			return textMessage.getText();
		}
		
		
		
		
		
}

