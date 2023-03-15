package com.dotdash.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class ContextMenuPOM extends TestBase {

	@FindBy(css="div#hot-spot")
	WebElement contextbox;
	
	public ContextMenuPOM() {
		PageFactory.initElements(driver,this);
	}
	public void rightClickCxtBox() {
		Actions act= new Actions(driver);
		act.contextClick(contextbox).perform();
	}
	
	public String getTextonAlert() {
		String alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
		return alertText;
		
		
	}
}
