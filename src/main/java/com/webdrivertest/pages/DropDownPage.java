package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivertest.utils.ElementUtil;

public class DropDownPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public DropDownPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By clickDropDown = By.id("dropdown");
	By firstOption = By.xpath("//option[@value='1']");
	By secondOption = By.xpath("//option[@value='2']");
	
	public String firstOptionDropDown() {
		elementUtil.selectDropDownValueByText(driver, clickDropDown, "Option 1");
		return elementUtil.doGetText(firstOption);
	}
	
	public String secondOptionDropDown() {
		elementUtil.selectDropDownValueByText(driver, clickDropDown, "Option 2");
		return elementUtil.doGetText(secondOption);
	}

}
