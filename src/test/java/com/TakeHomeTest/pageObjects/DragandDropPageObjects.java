package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragandDropPageObjects {
	
	WebDriver ldriver;
	public String header_text;

	public DragandDropPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	}
	
	@FindBy(xpath="//div[@id='column-a']")
	//@FindBy(id="column-a")
	private WebElement DragA;
	
	@FindBy(xpath="//div[@id='column-b']")
	//@FindBy(id="column-b")
	private WebElement DragB;
	
	@FindBy(xpath="//div[@id='column-a']//header")
	private WebElement headerB;
	
	public void dragdrop() {
		Actions actions1 =new Actions(ldriver);
		actions1.clickAndHold(DragA).moveToElement(DragB).release(DragB).build().perform();
		//actions.dragAndDrop(DragA,DragB).perform();
		header_text=headerB.getText();
		System.out.println(header_text);
	}

}
