package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import com.webdrivertest.utils.ElementUtil;

public class CheckBoxPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public CheckBoxPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By unCheckBox = By.xpath("//form[@id='checkboxes']//input[1]");
	By checkBox = By.xpath("//form[@id='checkboxes']//input[2]");
	
    public boolean isUnSelected() {
    	return elementUtil.doIsSelected(unCheckBox);
    }
    
    public boolean isSelected() {
    	return elementUtil.doIsSelected(checkBox);
    }
}
