package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivertest.utils.ElementUtil;

public class DynamicLoadingPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	By startBtn = By.xpath("//*[@id='start']/button");
	By helloText = By.xpath("//*[@id='finish']/h4");
	
	public DynamicLoadingPage clickOnStartBtn() {
        driver.findElement(startBtn).click();
        elementUtil.waitForElementPresent(helloText);
        return this;
    }

    public String verifyHelloWorldDisplayed() {
        return elementUtil.doGetText(helloText);
        
        //Assert.assertEquals(actual_displayed_text, expected_displayed_text, "[ERR] The text is not displayed!");
    }

}
