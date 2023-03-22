package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class IframePageElements extends CommonMethods {		
	
	@FindBy(xpath = "//*[@aria-label='Close']")
	public WebElement closeAlertBtn;	
	
	@FindBy(className = "tox-edit-area__iframe")
	public WebElement iframeElement;
	
	@FindBy(id = "tinymce")
	public WebElement textArea;
	
	
	public IframePageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
