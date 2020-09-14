package com.dotDash.DotDash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDrop {

	public DragAndDrop(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	

	@FindBy(xpath = "//div[@id='column-a']//header" )
	public static WebElement drag;

	@FindBy(xpath ="//div[@id='column-b']//header")
	public static WebElement drop;
	
	
	public WebElement drag() {
		return drag;
	}
	
	public WebElement drop() {
		return drop;
	}
	
}
