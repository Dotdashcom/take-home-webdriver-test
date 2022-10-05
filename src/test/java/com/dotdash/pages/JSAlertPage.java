package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class JSAlertPage extends BasePage{

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement clickForJSAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement clickForJSConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement clickForJSPrompt;

    @FindBy(css = "#result")
    public WebElement resultMsg;
}
