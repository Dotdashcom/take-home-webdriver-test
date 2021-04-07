package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class DragAndDropPage extends BaseClass {

	// The following Initialization of the Page factory
	
	public DragAndDropPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	// The following are Declaration the web elements

		@FindBy(xpath = "//a[contains(text(),'Drag and Drop')]")
		@CacheLookup
		WebElement Drag_And_Drop;
		
		@FindBy(xpath = "//div[@id='column-a']")
		@CacheLookup
		WebElement ColumnA;
		
		@FindBy(xpath = "//div[@id='column-b']")
		@CacheLookup
		WebElement ColumnB;
		
		
		
		// The following are the Utilization by creating methods for each of the
		// components.

		// get URL
		public void getUrl() {
			driver.get(Base_URL);
			Drag_And_Drop.click();
		}
		
		// perform drag and drop from A to B
		public void dragAndDrop() {
			Actions DragAndDrop = new Actions(driver);
			Action action = DragAndDrop.dragAndDrop(ColumnA, ColumnB).build();
	        action.perform();
			
		}
}
