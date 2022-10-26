package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePageObjects {

	WebDriver ldriver;

	public NotificationMessagePageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(partialLinkText="Click here")
	private WebElement ClickHereLink;
	
	@FindBy(xpath="//div[@id='flash']")
	private WebElement DisplayedMessage;
	
	public void ClickHere() {
		ClickHereLink.click();
	}
	
	public String messageDisplayed() {
		String text=DisplayedMessage.getText();
       // String trim_msg=text.substring(0, text.length() - 1);

		return text;
	}
}
