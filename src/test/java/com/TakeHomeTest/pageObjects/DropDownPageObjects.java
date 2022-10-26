package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPageObjects {
	WebDriver ldriver;

	public DropDownPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(id="dropdown")
	public WebElement Dropdown;

}
