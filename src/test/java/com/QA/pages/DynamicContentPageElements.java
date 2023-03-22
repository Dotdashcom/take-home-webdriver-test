package com.QA.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseUtils.CommonMethods;

public class DynamicContentPageElements extends CommonMethods {		
	
	@FindBy(xpath = "//*[@id='content']//img")
	public List <WebElement> images;	
	
	@FindBy(xpath = "//*[@id='content']//*[@class='large-10 columns']")
	public List <WebElement> descriptions;	
	
	public DynamicContentPageElements() {
		PageFactory.initElements(driver, this);
	}
	
}
