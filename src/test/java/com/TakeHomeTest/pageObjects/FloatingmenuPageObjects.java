package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingmenuPageObjects {

	WebDriver ldriver;

	public FloatingmenuPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(xpath="//div[@id='menu']")
	private WebElement menu;
	
	public boolean CheckMenuIsDisplayed() {
		boolean menudisplayed=false;
		menudisplayed=menu.isDisplayed();
		return menudisplayed;
	}
	
}
