package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class CheckBoxPage extends TestBase{
	
	
	@FindBy(xpath="//body//input[1]")
	WebElement checkBox1;
	
	@FindBy(xpath="//body//input[2]") 
	WebElement checkBox2;
	

	public CheckBoxPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateCheckBox1() {
		return checkBox1.isSelected();
	}
	
	public boolean validateCheckBox2() {
		return checkBox2.isSelected();
	}
	

}
