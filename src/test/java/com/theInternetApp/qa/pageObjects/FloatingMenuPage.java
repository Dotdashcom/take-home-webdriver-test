package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
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
public class FloatingMenuPage extends BaseClass{
	
	       // The following Initialization of the Page factory
			public FloatingMenuPage(WebDriver driver) {
		
				PageFactory.initElements(driver, this);
				waitHelper = new WaitHelper(driver);
			}
		
			// The following are Declaration the web elements
		
			@FindBy(xpath = "//a[contains(text(),'Floating Menu')]")
			@CacheLookup
			WebElement FloatingMenuLink;
			
			@FindBy(xpath = "//div[@id='menu']")
			@CacheLookup
			WebElement MenuBar;
		
		
			// The following are the Utilizations by creating methods for each of the
			// components.
		
			// get URL
			public void getUrl() {
				driver.get(Base_URL);
				FloatingMenuLink.click();
			}
		
			//scroll to see Floating Menu
			public void getFloatingMenu() {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,550)");
			}
			
			//check if the menu is displayed after scrolling
			public boolean isMenuDisplayed() {
				return MenuBar.isDisplayed();
			}
}
