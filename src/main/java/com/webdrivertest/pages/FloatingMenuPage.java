package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdrivertest.utils.ElementUtil;
import com.webdrivertest.utils.JavaScriptUtil;

public class FloatingMenuPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	public FloatingMenuPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	By menu = By.id("menu");
	
	public FloatingMenuPage scrollDownPage() {
        javaScriptUtil.scrollPageDown();
        return this;
    }
	
	public boolean verifyStillDisplayedOnTop() {
		WebElement element = driver.findElement(menu);
		return javaScriptUtil.isInViewPort(driver, element);
	}

}
