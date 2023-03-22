package com.main.TakeHomeShivam;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends TestBase {
    
	private WebDriver driver;

	/**
	 * 
	 * @param driver
	 * Constructor PageBase to help initialize Webelements of every page class using PageFactory
	 */
	public PageBase(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void waitTillElementVisible(WebElement web_element) {
	     new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(web_element));
	}
	
	// Common Webelement manipulations
	public void clickWebElement(WebElement web_element) {
		 new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(web_element));
		web_element.click();
	}

	public void clickWebElementUsingActions(WebElement web_element) {
		Actions act = new Actions(driver);
		act.moveToElement(web_element).click().build().perform();
	}

	
	public void sendKeysWebElementUsingActions(WebElement web_element, String keys) {
		waitTillElementVisible(web_element);
		Actions action = new Actions(driver);
		action.sendKeys(web_element, keys).build().perform();
	}
		
}
