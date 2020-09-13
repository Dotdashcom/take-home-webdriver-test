package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class JavaScriptAlertPage extends TestBase{
	
	@FindBy(xpath="//button[contains(text(),'Click for JS Alert')]")
	WebElement alertBtn;
	
	public JavaScriptAlertPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String alertMsg() {
		
		alertBtn.click();
		String result = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Actual : " + result);
		return result;
	}

}
