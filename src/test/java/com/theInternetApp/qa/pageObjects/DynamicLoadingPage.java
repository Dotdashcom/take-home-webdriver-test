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
public class DynamicLoadingPage extends BaseClass{

	      // The following Initialization of the Page factory
			public DynamicLoadingPage(WebDriver driver) {

				PageFactory.initElements(driver, this);
				waitHelper = new WaitHelper(driver);
			}

			// The following are Declaration the web elements

			@FindBy(xpath = "//a[contains(text(),'Dynamic Loading')]")
			@CacheLookup
			WebElement DynamicLoadingLink;
			
			@FindBy(xpath = "//a[contains(text(),'Example 1: Element on page that is hidden')]")
			@CacheLookup
			WebElement ElementLink;
			
			@FindBy(xpath = "//button[contains(text(),'Start')]")
			@CacheLookup
			WebElement StartButton;

			@FindBy(id = "finish")
			@CacheLookup
			WebElement FinishText;



			// The following are the Utilizations by creating methods for each of the
			// components.

			// get URL
			public void getUrl() {
				driver.get(Base_URL);
				DynamicLoadingLink.click();
				ElementLink.click();
			}

			//click On Start Button
			public void clickOnStartButton() {
				StartButton.click();
				waitHelper.WaitForElement(FinishText, 30);
			}
			
			//get Message Text
			public String getMessageText() {
				return FinishText.getText();
			}
}
