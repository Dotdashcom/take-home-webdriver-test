package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DragAndDropPage {

	WebDriver driver;

	@FindBy(xpath = ("//div[@class='column'][1]"))
	WebElement box_A;

	@FindBy(xpath = ("//div[@class='column'][2]"))
	WebElement box_B;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyDragAndDrop() {
		Actions action = new Actions(driver);
		action.dragAndDrop(box_A, box_B).perform();
		Assert.assertEquals(box_A.getText(), "A");

	}

}
