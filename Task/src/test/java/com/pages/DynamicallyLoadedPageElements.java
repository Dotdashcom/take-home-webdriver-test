package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPageElements extends BaseClass{

	
	//Start button element location
	@FindBy(xpath = "//div[@class='example']/div")
	public WebElement startBtn;
	
	//text location after loading
	@FindBy(css = "div#finish")
	public WebElement finishText;
	
	public DynamicallyLoadedPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
