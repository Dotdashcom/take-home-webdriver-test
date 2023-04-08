package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class IframePage extends Base{
	
	@FindBy(id="mce_0_ifr")
	WebElement iframeElement;
	
	@FindBy(xpath="//body")
	WebElement textField;
	
	public IframePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void switchToIframe() {
		driver.switchTo().frame(iframeElement);
	}
	
	public void enterTheText() {
		textField.sendKeys(Keys.CONTROL+"a");
		textField.sendKeys(Keys.ENTER);
		textField.sendKeys("Type the text inside the IFRAME");
		
	}
	
	public String getTheEnteredtext() {
		String textEntered=textField.getText();
		return textEntered;
	}

}
