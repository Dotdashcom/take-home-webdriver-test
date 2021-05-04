package com.arthi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

/**
 * 
 * @author Arthina Kumar
 *
 */
public class SecureAreaPage extends PageBase{
	
	@FindBy(xpath="//div[@class='example']//h2")
	private WebElement centerTextCheck;
	
	@FindBy(id="flash")
	private WebElement successMessageLbl;
	
	
	public SecureAreaPage(WebDriver driver) {
		super(driver);
	}


	public SecureAreaPage verifyPageLable(String expectedText) {
		assertEquals(centerTextCheck, expectedText);
		return this;	
	}
	
	public SecureAreaPage verifysuccessMessage(String expectedText) {
		assertContains(successMessageLbl, expectedText);
		
		return this;
	}
	
	

	

}
