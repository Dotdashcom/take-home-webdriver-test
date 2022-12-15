package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class DynamicControlsElements extends CommonMethods {

	@FindBy (xpath = "//form[@id=\"checkbox-example\"]/button")
	public WebElement raButton;
	
	@FindBy (id = "checkbox")
	public WebElement checkbox;
	
	@FindBy (css = "input[type='text']")
	public WebElement textbox;
	
	@FindBy (xpath = "//form[@id=\"input-example\"]/button")
	public WebElement edButton;
	
	@FindBy (id = "message")
	public WebElement msg;
	
	

	
	public DynamicControlsElements() {
		PageFactory.initElements(driver, this);
	}
}
