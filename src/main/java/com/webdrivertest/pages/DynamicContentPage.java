package com.webdrivertest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.webdrivertest.utils.ElementUtil;

public class DynamicContentPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	By dynamic_contents = By.xpath("//div[@class='large-10 columns']");
	
    public String getContentBasedOnIndex(int index) {
        List<WebElement> contents = driver.findElements(dynamic_contents);
        return contents.get(index).getText();
    }

}
