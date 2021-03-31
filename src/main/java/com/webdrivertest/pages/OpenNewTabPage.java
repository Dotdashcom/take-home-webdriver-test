package com.webdrivertest.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivertest.utils.ElementUtil;

public class OpenNewTabPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public OpenNewTabPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	By textOnPage = By.xpath("//h3[normalize-space()='New Window']");
	By click = By.linkText("Click Here");
	
	public String verifyTextOnNewTab() {
		elementUtil.waitForElementPresent(textOnPage);
		return elementUtil.doGetText(textOnPage);
	}
	public void switchWindows() {
		String currentWindowHandle = driver.getWindowHandle();
	    ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
	    for (String window:windowHandles){
	        if (window != currentWindowHandle){
	            driver.switchTo().window(window);
	        }
	    }
	}
	public void clickLink() {
		elementUtil.waitForElementPresent(click);
		elementUtil.doClick(click);
	}
}
