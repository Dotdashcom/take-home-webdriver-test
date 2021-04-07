package com.theInternetApp.qa.pageObjects;

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
public class DynamicContentPage extends BaseClass {

	// The following Initialization of the Page factory
	public DynamicContentPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// The following are Declaration the web elements

	@FindBy(xpath = "//a[contains(text(),'Dynamic Content')]")
	@CacheLookup
	WebElement DynamicContent;

	@FindBy(xpath = "//a[contains(text(),'click here')]")
	@CacheLookup
	WebElement refreshLink;

	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[1]/img")
	@CacheLookup
	WebElement displayedImg;

	// The following are the Utilizations by creating methods for each of the
	// components.

	// get URL
	public void getUrl() {
		driver.get(Base_URL);
		DynamicContent.click();
	}

	// verify Dynamic Content
	public void verifyDynamicContent() {

			for (int i = 0; i < 3; i++) {
				refreshLink.click();
				Assert.assertEquals(false, displayedImg.getText() == "/img/avatars/Original-Facebook-Geek-Profile-Avatar-7.jpg");
			}
		
	}
		
}
