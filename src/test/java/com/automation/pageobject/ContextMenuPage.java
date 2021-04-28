package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ContextMenuPage {
	public static final By CONTEXTMENUHEADER=By.xpath("//h3[text()='Context Menu']");
	public static final By CONTEXTMENU=By.id("hot-spot");
	
	public static void validateContextMenuHeader(WebDriver driver) {
		WebElement element= driver.findElement(CONTEXTMENUHEADER);
		Assert.assertTrue(element.isDisplayed(), "context menu HEADER is not Displaying");

	}
	public static void clickContextMenuAndValidateText(WebDriver driver) {
		WebElement element= driver.findElement(CONTEXTMENU);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		//You selected a context menu
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals("You selected a context menu",text,"Alert Text not matching");
	}
	
 
	
}
