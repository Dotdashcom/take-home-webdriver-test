package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragandDropPage {
	public static final By DRAGANDDROPHEADER=By.xpath("//h3[text()='Drag and Drop']");
	public static final By SOURCE=By.id("column-a");
	public static final By SOURCE_TEXT=By.xpath("//div[@id='column-a']/header");
	public static final By TARGET=By.id("column-b");
	public static final By TARGET_TEXT=By.xpath("//div[@id='column-b']/header");
	public static void validateDragAndDropHeader(WebDriver driver) {
		WebElement element= driver.findElement(DRAGANDDROPHEADER);
		Assert.assertTrue(element.isDisplayed(), "Drag and Drop header is not Displaying");

	}
	
	public static void DragAndDropAction(WebDriver driver) {
		WebElement source=driver.findElement(SOURCE);			
        WebElement target=driver.findElement(TARGET);
        String sourceText_Before=driver.findElement(SOURCE_TEXT).getText();			
        String targetText_Before=driver.findElement(TARGET_TEXT).getText();
        Actions act=new Actions(driver);					
        act.dragAndDrop(source, target).build().perform();
         
        String sourceText_After=driver.findElement(SOURCE_TEXT).getText();		
        String targetText_After=driver.findElement(TARGET_TEXT).getText();
        Assert.assertEquals(targetText_Before, targetText_After, "Source is not exchanged");
        Assert.assertEquals(sourceText_Before, sourceText_After, "Target is not exchanged");
        
        
	}
	

}
