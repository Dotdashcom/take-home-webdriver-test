package com.qa.selenium.pages;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class DragAndDropPage extends TestBase{
	
	@FindBy (xpath= "//div[@id='columns']/div[1]")
	WebElement firstBlock;
		
	@FindBy (xpath= "//div[@id='columns']/div[2]")
	WebElement secondBlock;
	
	@FindBy (xpath ="//div[@id=\"column-a\"]/header")
	WebElement firstHeader;
	
	
	@FindBy (xpath ="//div[@id=\"column-b\"]/header")
	WebElement secondHeader;
	
	
	
	
	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
	}

	public void dragAndDropAction() {
			Point p = secondBlock.getLocation();
		System.out.println(p);
		Actions builder = new Actions(driver);

		builder.doubleClick(firstBlock).moveByOffset(370, 88).release().build().perform();
	
		//		builder.dragAndDrop(firstBlock, secondBlock).build().perform();
//		builder.moveToElement(firstBlock)
//        .pause(Duration.ofSeconds(2))
//        .clickAndHold(firstBlock)
//        .pause(Duration.ofSeconds(2))
//        .moveByOffset(0,50) //change the x, y values to be applicable for your cases
//        .moveByOffset(0,50)
//        .pause(Duration.ofSeconds(1))
//        .release().build().perform();
	}
	
	public String headerCheck1() {
		return firstHeader.getText();
	}

	public String headerCheck2() {
		return secondHeader.getText();
	}
	public WebElement aBox() {
		return firstBlock;
	}
	public WebElement bBox() {
		return secondBlock;
	}
}
