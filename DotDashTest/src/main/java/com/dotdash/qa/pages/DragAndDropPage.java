package com.dotdash.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class DragAndDropPage extends TestBase{
	
	@FindBy(xpath="//div[@id='column-a']")
	WebElement columnA;
	
	@FindBy(xpath="//div[@id='column-b']")
	WebElement columnB;
	
	

	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void dragAndDrop() {
		Actions act = new Actions(driver);
		  act.clickAndHold(columnA).pause(Duration.ofSeconds(10))
		  .moveToElement(columnB) .release() .build() .perform();
		 
		
	}
}
