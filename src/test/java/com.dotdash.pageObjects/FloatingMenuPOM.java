package com.dotdash.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class FloatingMenuPOM extends TestBase{

	@FindBy(css="div#menu")
	WebElement menu;
	
	public FloatingMenuPOM() {
		PageFactory.initElements(driver,this);
	}
	public boolean usercheckFloatingMenu() {
		boolean flag=menu.isDisplayed();
        return flag;  
		
	}
	
	public void userscrollToBottom() {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollBy(0,1500)", "");	
		jse6.executeScript("window.scrollBy(0,2000)", "");
		jse6.executeScript("window.scrollBy(0,2500)", "");
	}
	

}
