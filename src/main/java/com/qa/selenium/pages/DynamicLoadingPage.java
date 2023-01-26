package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class DynamicLoadingPage  extends TestBase{

	@FindBy (css="div[id='start']>button")
	WebElement startBtn;
	
	@FindBy (css = "div[id='finish']>h4")
	WebElement textElement;
	
	public DynamicLoadingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void startBtnClick() {
		startBtn.click();
		
	}
	public WebElement TextElement() {
		return textElement;
	}
	public String HelloText() {
		return textElement.getText();
	}

}
