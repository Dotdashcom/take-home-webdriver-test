package com.QA.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class MouseHoverPageElements extends CommonMethods {			
	
	@FindBy(className = "figure")
	public List<WebElement> images;
	
	@FindBy(className = "figcaption")
	public List<WebElement> additionalInfo;	
	
	public MouseHoverPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
