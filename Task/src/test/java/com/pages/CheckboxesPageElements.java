package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPageElements extends BaseClass{

	@FindBy(xpath = "//input[@type='checkbox']")
	public List<WebElement> checkbox;
	
	public CheckboxesPageElements(){
		PageFactory.initElements(driver, this);
	}
	
}
