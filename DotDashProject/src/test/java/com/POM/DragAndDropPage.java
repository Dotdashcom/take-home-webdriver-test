package com.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage {
	public WebDriver driver;


	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}


	@FindBy (xpath = "//div[@id='column-a']")
	WebElement drag;

	@FindBy (xpath = "//div[@id='column-b']")
	WebElement drop;

	public void DragDrop(){
		Actions ac = new Actions(driver);
		ac.dragAndDrop(drag, drop).build().perform();
	}
}
