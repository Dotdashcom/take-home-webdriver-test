package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPage {
    public JavaScriptAlertPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//button[1])[1]")
    public WebElement jsAlert;
    @FindBy(xpath = "(//button[1])[2]")
    public WebElement jsConfirm;
    @FindBy(xpath = "(//button[1])[3]")
    public WebElement jsPrompt;
    @FindBy(xpath = "//p[@id='result']")
    public WebElement resultText;
}
