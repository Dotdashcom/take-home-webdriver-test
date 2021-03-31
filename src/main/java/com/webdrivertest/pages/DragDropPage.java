package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivertest.utils.ElementUtil;

public class DragDropPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public DragDropPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By columnA = By.id("column-a");
	By columnB = By.id("column-b");
	
	public String getTextColumnA() {
		elementUtil.waitForElementPresent(columnA);
		return elementUtil.doGetText(columnA);
	}
	
	public String getTextColumnB() {
		elementUtil.waitForElementPresent(columnB);
		return elementUtil.doGetText(columnB);
	}
	
	public void dragDropHandle() {
		elementUtil.doDragDrop(driver, columnA, columnB);
	}

}
