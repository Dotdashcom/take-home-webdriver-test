package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPageElements extends BaseClass{

	@FindBy(xpath = "//div[@class='example']/a")
	public WebElement clickHereBtn;
	
	@FindBy(xpath = "//div[@class='example']/h3")
	public WebElement newWindowMessage;
	
	public NewWindowPageElements() {
		PageFactory.initElements(driver, this);
	}
}
