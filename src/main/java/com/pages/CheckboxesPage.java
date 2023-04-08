package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class CheckboxesPage extends Base {
	@FindBy(xpath="//input[@type='checkbox'][1]")
	WebElement checkBox_1;
	
	@FindBy(xpath="//input[@type='checkbox'][2]")
	WebElement checkBox_2;
	

	public CheckboxesPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnCheckBox_1() {
		checkBox_1.click();
	}
	public boolean validateCheckbox_1IsSelected() {
		boolean flag=checkBox_1.isSelected();
		return flag;
	}
	
	public void clickOnCheckBox_2() {
		checkBox_2.click();
	}
	public boolean validateCheckbox_2IsSelected() {
		boolean flag=checkBox_2.isSelected();
		return flag;
	}


}
