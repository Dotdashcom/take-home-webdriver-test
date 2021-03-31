package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.webdrivertest.utils.ElementUtil;

public class ContextMenuPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By contextSquare = By.id("hot-spot");
	
	public void rightClick() {
		elementUtil.waitForElementPresent(contextSquare);
		elementUtil.doContextClick(driver, contextSquare);
	}
	
	public String alertHandle() {
		return elementUtil.getAlertText(driver);
	}

}
