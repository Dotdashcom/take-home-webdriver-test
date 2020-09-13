package com.dotdash.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class ContextMenuPage extends TestBase{
	
	@FindBy(xpath="//div[@id='hot-spot']") 
	WebElement hotSpot;
	
	public ContextMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String clickMenu() {
		Actions act = new Actions(driver);
		act.contextClick(hotSpot).perform();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}
}
