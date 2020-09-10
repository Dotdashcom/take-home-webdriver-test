package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPageElements extends BaseClass{
	
	//Floating Menu
	@FindBy(xpath = "//div[@class='example']")
	public WebElement floatingMenu;
	
	public FloatingMenuPageElements() {
		PageFactory.initElements(driver, this);
	}

}
