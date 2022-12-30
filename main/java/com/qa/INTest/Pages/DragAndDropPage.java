package com.qa.INTest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class DragAndDropPage extends TestBase {

	@FindBy(linkText = "Drag and Drop")
	WebElement dragAnddrop;

	@FindBy(id = "column-a")
	WebElement clmA;
	@FindBy(id = "column-b")
	WebElement clmB;

	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnDragAndDropLink() {
		dragAnddrop.click();

	}

	public String performDragging() {
		Actions builder = new Actions(driver);
		builder.dragAndDrop(clmA, clmB).build().perform();
		return clmA.getText();
		
	}
}
