package com.qa.selenium.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class ContextMenuPage extends TestBase{
	
	@FindBy (id = "hot-spot")
	WebElement contextSquare;
	

	
	public ContextMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContext() {
		Actions builder = new Actions(driver);
		builder.contextClick(contextSquare).build().perform();
		
	}
	
	public String alertConfirm() {
		Alert al = driver.switchTo().alert();
	return	al.getText();
	//System.out.println("Alert is "+ al.getText());	
		
	}

}
