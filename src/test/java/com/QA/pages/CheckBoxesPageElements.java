package com.QA.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class CheckBoxesPageElements extends CommonMethods {		
	
	@FindBy(xpath = "//*[@type='checkbox']")
	public List <WebElement> checkboxes;
	
	public CheckBoxesPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
