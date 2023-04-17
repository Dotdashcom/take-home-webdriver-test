package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/dynamic_loading/2
public class DynamicLoadingPage {
    @FindBy(xpath = "//button")
    public WebElement buttonStart;

    @FindBy(xpath = "//*[text() = 'Hello World!']")
    public WebElement HelloWorld;


 








    public DynamicLoadingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
