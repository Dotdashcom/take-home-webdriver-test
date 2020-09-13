package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class DynamicContentPage extends TestBase{

	
	
	@FindBy(xpath="//div[@id='content']/div/div[2]")
	WebElement linkText;
	
	public DynamicContentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContent(){
	
		String textBeforeRefresh = linkText.getText();
		driver.navigate().refresh();
		String textAfterRefresh = linkText.getText();
		if(textBeforeRefresh.equals(textAfterRefresh)) {
			return false;
		}
		else {
			return true;
		}
			
	}
}
