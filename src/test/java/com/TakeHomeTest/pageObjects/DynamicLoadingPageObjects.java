package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPageObjects {

	WebDriver ldriver;
	
	public DynamicLoadingPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@id='content']//a[1]")
	private WebElement FirstLink;
	
	@FindBy(xpath="//button[text()='Start']")
	public WebElement StartButton;
	
	@FindBy(xpath="//h4[text()='Hello World!']")
	public WebElement helloworldtext;
	
	public void clickfirstlink() {
		FirstLink.click();
	}
	public void ClickStart() {
		
			StartButton.click();
		
	}
	
	/*public String gethelloworldtext() {
		return helloworldtext.getText();
	}*/
	
}
