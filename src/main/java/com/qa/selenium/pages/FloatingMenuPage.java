package com.qa.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class FloatingMenuPage extends TestBase{

	@FindBy (id = "menu")
	WebElement menu;
	

	
	public FloatingMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean menuDisplay() {
		return menu.isDisplayed();
		
	}
	public void scrollDown() {
			JavascriptExecutor js =  (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,4558)", "");
			
		
	}
					
	

}
