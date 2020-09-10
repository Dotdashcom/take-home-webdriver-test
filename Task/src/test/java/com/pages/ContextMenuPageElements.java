package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPageElements extends BaseClass {
	
	//hot spot element location
	@FindBy(xpath = "//div[@id='hot-spot']")
	public WebElement hotSpot;
	
	public ContextMenuPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
