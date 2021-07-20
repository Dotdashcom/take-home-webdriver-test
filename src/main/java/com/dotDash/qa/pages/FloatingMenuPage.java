package com.dotDash.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class FloatingMenuPage extends TestBase{
	//Finding the link to the context Menu page
	@FindBy(xpath= "//a[@href='/floating_menu']")  
	WebElement floatingMenu;
	
	//Finding the floating menu
	@FindBy(id= "menu")  
	WebElement menu;
	
	
	//Initializing the Page Objects:
	public FloatingMenuPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean floatingMenu(){
		floatingMenu.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		boolean menuDisp = menu.isDisplayed();
		return menuDisp;

	}

}
