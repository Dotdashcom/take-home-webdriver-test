package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/dynamic_controls
public class DynamicControlsPage {
    
    @FindBy(css = "input")
    public WebElement inputCheckBox;

    @FindBy(css = "button[onclick='swapCheckbox()']")
    public WebElement buttonRemoveCheckBox;

    @FindBy(css = "button[onclick='swapInput()']")
    public WebElement buttonEnableText;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputTxt;


    @FindBy(xpath = "//*[@id='message']")
    public WebElement pMessage;









    public DynamicControlsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
