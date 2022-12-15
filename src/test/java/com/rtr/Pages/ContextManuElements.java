package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class ContextManuElements extends CommonMethods {
	
	@FindBy (id = "hot-spot")
	public WebElement box;
	
	
	public ContextManuElements() {
		PageFactory.initElements(driver, this);
	}
			
}
