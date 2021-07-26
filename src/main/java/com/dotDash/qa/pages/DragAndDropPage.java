package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class DragAndDropPage extends TestBase {
	// Instantiating action class
	Actions actions = new Actions(driver);

	// Finding the link to the Drag and Drop page
	@FindBy(xpath = "//a[@href='/drag_and_drop']")
	WebElement dragAndDrop;

	// Finding Column A
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]")
	WebElement columnA;

	// Finding Column B
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]")
	WebElement columnB;

	// Initializing the Page Objects:
	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	//Drag and Drop test function 
	public boolean dragAndDrop() {
		dragAndDrop.click();
		String textBoxOne = columnA.getText();
		String textBoxTwo = columnB.getText();

		actions.dragAndDrop(columnA, columnB).build().perform();

		if (columnA.getText().equalsIgnoreCase(textBoxTwo) && columnB.getText().equalsIgnoreCase(textBoxOne)) {
			return true;
		} else {
			return false;
		}

	}
}
