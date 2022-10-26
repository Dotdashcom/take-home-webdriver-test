package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPageObjects {

	WebDriver ldriver;

	public NewWindowPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(partialLinkText="Click Here")
	private WebElement Windowlink;
	
	@FindBy(xpath="//div/h3")
	private WebElement newtabtext;
	
	public void Clicklink() {
		Windowlink.click();
	}
	
	public String checknewtabtext() {
		String checktext=newtabtext.getText();
		return checktext;
	}
}
