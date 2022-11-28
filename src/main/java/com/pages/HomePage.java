package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basetest.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id='content']//h2")
	@CacheLookup
	WebElement secureAreaLabel;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifysecureAreaLabel(){
		return secureAreaLabel.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	

}
