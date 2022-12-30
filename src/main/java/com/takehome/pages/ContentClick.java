package com.takehome.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContentClick {
	WebDriver driver;
	
	@FindBy(id = "hot-spot")WebElement box;
	
	
	
	public ContentClick(WebDriver driver, String baseurl)
	{
		this.driver =driver;
		String url = baseurl + "/" + "context_menu";
		driver.get(url);
		PageFactory.initElements(driver,this);
	}
	
	
	
	public WebElement getboxele()
	{
		return box;
	}
	
	
	
	
	
}

