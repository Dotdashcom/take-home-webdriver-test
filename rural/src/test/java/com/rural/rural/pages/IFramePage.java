package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/iframe
public class IFramePage {


    @FindBy(xpath = "//div[@Class=\"tox-icon\"]")
    public WebElement close;

    @FindBy(xpath = "\"//*[text()='Your content goes here.']\"")
    public WebElement chat;

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
