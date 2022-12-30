package com.qa.INTest.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.INTest.TestBase.TestBase;

public class ContextMenuPage extends TestBase{
	
	@FindBy(linkText = "Context Menu")
	WebElement contextMenu;
	
	@FindBy(id = "hot-spot")
	WebElement box;
	
	public ContextMenuPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnContextMenuLink() {
		contextMenu.click();

	}
	
	public boolean performRightClick() {

		Actions builder = new Actions(driver);
		builder.contextClick(box).perform();
		
		Alert al = driver.switchTo().alert();
		al.accept();
	
	return	box.isDisplayed();
	}
	
	
}
