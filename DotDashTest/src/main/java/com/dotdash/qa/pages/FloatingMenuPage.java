package com.dotdash.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class FloatingMenuPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Home')]")  
	WebElement homeItem;
	
	public FloatingMenuPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean floatingMenu() {
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		boolean b = homeItem.isDisplayed();
		System.out.println("Is Home Item present : " + b);
		return b;
	}

}
