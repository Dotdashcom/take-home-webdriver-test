package com.takehome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragandDropCheck {
	
	WebDriver driver;
	@FindBy(id = "column-a")WebElement elementA;
	@FindBy(id = "column-b")WebElement elementB;
	
	
	
	
	public DragandDropCheck(WebDriver driver,String baseurl)
	{
		this.driver=driver;
		String url = baseurl + "/" + "drag_and_drop";
		driver.get(url);
		PageFactory.initElements(driver,this);
	}
	
	
	
	public WebElement getElementA()
	{
		return elementA;
	}
	

	public WebElement getElementB()
	{
		return elementB;
	}
	
	
	
}
