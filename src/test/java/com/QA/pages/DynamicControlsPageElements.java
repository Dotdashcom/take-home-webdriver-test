package com.QA.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class DynamicControlsPageElements extends CommonMethods {		
	
	@FindBy(id = "checkbox")
	public List<WebElement> checkbox;	
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	public WebElement removeBtn;	
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	public WebElement addBtn;
	
	@FindBy(id = "message")
	public WebElement message;	
	
	@FindBy(xpath = "//button[contains(text(),'Disable')]")
	public WebElement disableBtn;	
	
	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	public WebElement enableBtn;
	
	@FindBy(xpath = "//*[@type='text']")
	public WebElement text;
	
	
	public DynamicControlsPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
