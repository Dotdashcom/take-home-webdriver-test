package com.dotdash.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.testUtils.TestBase;

public class CheckboxPOM extends TestBase {

	
	@FindBy(css="form#checkboxes>input:nth-of-type(1)")
	WebElement checkbox1;
	
	@FindBy(css="form#checkboxes>input:nth-of-type(2)")
	WebElement checkbox2;
	
	public CheckboxPOM() {
		PageFactory.initElements(driver,this);
	}	

	public boolean verifyCheckBoxIsChecked(WebElement ele) {
		Boolean status=ele.isSelected();
		return status;
	}
	public WebElement clicksCheckBox1() {
		checkbox1.click();
		return checkbox1;
	}
}
