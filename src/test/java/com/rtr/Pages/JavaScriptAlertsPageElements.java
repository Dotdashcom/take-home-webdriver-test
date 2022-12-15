package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class JavaScriptAlertsPageElements extends CommonMethods{

	@FindBy(css = "#content > div > ul > li:nth-child(1) > button")
	public static WebElement jsalert;
	
	@FindBy(css = "#content > div > ul > li:nth-child(2) > button")
	public static WebElement jsconfirm;
	
	@FindBy(css = "#content > div > ul > li:nth-child(3) > button")
	public static WebElement jsprompt;
	
	@FindBy(id = "result")
	public static WebElement result;
	
	
	

	public JavaScriptAlertsPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
