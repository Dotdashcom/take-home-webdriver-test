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
public class IframePage extends BaseClass {

	// The following Initialization of the Page factory
	public IframePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// The following are Declaration the web elements

	@FindBy(xpath = "//a[contains(text(),'Frames')]")
	@CacheLookup
	WebElement FramesLink;
	
	@FindBy(xpath = "//a[contains(text(),'iFrame')]")
	@CacheLookup
	WebElement iFrameLink;
	
	@FindBy(id = "mce_0_ifr")
	@CacheLookup
	WebElement iFrame;
	
	@FindBy(id = "tinymce")
	@CacheLookup
	WebElement BodyContent;


	// The following are the Utilizations by creating methods for each of the
	// components.

	// get URL
	public void getUrl() {
		driver.get(Base_URL);
		FramesLink.click();
		iFrameLink.click();
	}

	// switch to Iframes
	public void getIframe() {
		driver.switchTo().frame("mce_0_ifr");
	}

	// get text from body
	public String getBodyContent() {
		return BodyContent.getText();
	}
}
