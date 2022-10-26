package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPageObjects {
	
	WebDriver ldriver;

	public ContextMenuPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(xpath="//div[@id='hot-spot']")
	private WebElement Contextmenu;
	
	public void right_click() {
		Actions actions=new Actions(ldriver);
		actions.contextClick(Contextmenu).build().perform();
		
	}
	

}
