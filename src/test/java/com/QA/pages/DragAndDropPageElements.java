package com.QA.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class DragAndDropPageElements extends CommonMethods {		
	
	@FindBy(id = "column-a")
	public WebElement columnA;
	
	@FindBy(id = "column-b")
	public WebElement columnB;
	
	public DragAndDropPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
