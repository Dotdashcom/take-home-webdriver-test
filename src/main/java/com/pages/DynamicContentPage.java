package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.base.Base;

public class DynamicContentPage extends Base{
	
	@FindBy(xpath="//body//div//div//div[@id='content']//div[1]//div[2]")
	WebElement contentText ;
	
	public DynamicContentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getContentText() {
		String text=contentText.getText();
		return text;
	}
	public void refreshThePage() {
		driver.navigate().refresh();
		
	}
	
}
