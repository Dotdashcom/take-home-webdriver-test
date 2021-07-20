package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class ContextMenuPage extends TestBase {
	//Instantiating  action class
	Actions actions = new Actions(driver);
	
	//Finding the link to the context Menu page
	@FindBy(xpath= "//a[@href='/context_menu']")  
	WebElement contextMenu;
	
	//Finding Context Menu
	@FindBy(id ="hot-spot") 
	WebElement hotSpot;
	
	//Initializing the Page Objects:
	public ContextMenuPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public String contextMenu(){
		contextMenu.click();
		actions.contextClick(hotSpot).perform();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertText; 
		
	}

}
