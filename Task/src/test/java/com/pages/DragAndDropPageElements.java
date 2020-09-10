package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPageElements extends BaseClass {
	
	//column A location
	@FindBy(xpath = "//div[@id='column-a']")
	public WebElement columnA;
	
	//column B location
	@FindBy(xpath = "//div[@id='column-b']")
	public WebElement columnB;
	
	public DragAndDropPageElements() {
		PageFactory.initElements(driver, this);
	}

}
