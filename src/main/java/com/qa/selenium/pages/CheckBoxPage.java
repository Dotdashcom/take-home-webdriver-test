package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class CheckBoxPage extends TestBase{

	
	@FindBy (xpath = "//body/div[2]/div[1]/div[1]/form[1]/input[1]")
	WebElement checkbox1;

	@FindBy (xpath = "//body/div[2]/div[1]/div[1]/form[1]/input[2]")
	WebElement checkbox2;

	
	//Page Factory
	public CheckBoxPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean check1() {
		return checkbox1.isSelected();
	}
	
	public void checkSelect1() {
		checkbox1.click();
	}
	
	public void checkSelect2() {
		checkbox2.click();
	}
	
	public boolean check2() {
		return checkbox2.isSelected();

	}

}
