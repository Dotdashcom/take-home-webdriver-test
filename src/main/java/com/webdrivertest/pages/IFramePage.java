package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdrivertest.utils.ElementUtil;

public class IFramePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public IFramePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By iFrame = By.id("mce_0_ifr");
    By iFrameBody = By.id("tinymce");
    private String textInputInIframe = "";
    
    public String inputTextInIframe(String text) {
        textInputInIframe = text;
        driver.switchTo().frame(driver.findElement(iFrame));
        WebElement element = driver.findElement(iFrameBody);
        element.clear();
        element.sendKeys(text);
        driver.switchTo().defaultContent();
		return text;
        
    }
    
    public String verifyInputText() {
        driver.switchTo().frame(driver.findElement(iFrame));
        String actualTextInIframe = driver.findElement(iFrameBody).getText();
        driver.switchTo().defaultContent();
		return actualTextInIframe;
    }

}
