package com.rtr.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class DynamicContentPageElements extends CommonMethods {

	@FindBy (xpath = "//div[@id='content']/div[1]/div[2]")
	public WebElement c1;
	
	@FindBy (xpath = "//div[@id='content']/div[2]/div[2]")
	public WebElement c2;
	
	@FindBy (xpath = "//div[@id='content']/div[3]/div[2]")
	public WebElement c3;

	
	public DynamicContentPageElements() {
		PageFactory.initElements(driver, this);
	}
}
