package com.rtr.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rtr.utils.CommonMethods;

public class CheckboxesPageElements extends CommonMethods{
	
	@FindBy (css = "input[type=checkbox]")
	public List<WebElement> checkBoxes;
	
	
	public CheckboxesPageElements() {
		PageFactory.initElements(driver, this);
	}

}
