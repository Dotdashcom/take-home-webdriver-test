package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/javascript_error
public class JavaScriptErrorPage {


    @FindBy(xpath = "//*[text() = '\n      This page has a JavaScript error in the onload event.\n      This is often a problem to using normal Javascript injection\n      techniques.\n    ']")
    public WebElement pThisPageHasJava;



    public JavaScriptErrorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
