package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class FloatingMenuPageElements extends CommonMethods {
	
	@FindBy (id = "menu")
	public WebElement floadmenu;

	
	public FloatingMenuPageElements() {
		PageFactory.initElements(driver, this);
	}

}
