package com.theInternetApp.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.theInternetApp.qa.Utilities.BaseClass;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class ContextMenuPage extends BaseClass {

	// The following Initialization of the Page factory

	public ContextMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// The following are Declaration the web elements

	@FindBy(xpath = "//a[contains(text(),'Context Menu')]")
	@CacheLookup
	WebElement ClickOnContextMenu;

	@FindBy(id = "hot-spot")
	@CacheLookup
	WebElement RightClickOnBox;

	// The following are the Utilizations by creating methods for each of the
	// components.

	// get URL
	public void getUrl() {
		driver.get(Base_URL);
		ClickOnContextMenu.click();
	}

	// Right click on Box
	public boolean rightClickOnBox() {
		Actions actions = new Actions(driver);

		actions.contextClick(RightClickOnBox).perform();
		driver.switchTo().alert();
		return true;

	}
}
