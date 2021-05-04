package com.arthi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;


/**
 * 
 * @author Arthina Kumar
 *
 */

public class DragAndDropPage extends PageBase {
	
	


	private static final String Base_URL = "http://localhost:7080/drag_and_drop";
	
	@FindBy(id="column-a")
	private WebElement dragElementA;
	
	@FindBy(id="column-b")
	private WebElement dragElementB;
		
			 
	public DragAndDropPage(WebDriver driver) {
		super(driver);
		
	}
	
	public DragAndDropPage navigateToDragAndDropPage() {
		driver.get(Base_URL);
		return this;
		
	}
	
	public DragAndDropPage performDragAndDragAction() {
		 Actions act = new Actions(driver);
		 //act.moveToElement(dragElementB).build().perform();
		 act.clickAndHold(dragElementA)
		 .moveToElement(dragElementB)
	 	.release(dragElementB)
		 .build()
		 .perform();
		 return this;
		
	}

	
		
}
