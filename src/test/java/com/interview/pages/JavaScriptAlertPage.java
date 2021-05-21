package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPage {
    public JavaScriptAlertPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//button[1])[1]")
    public WebElement JsAlert;
    @FindBy(xpath = "(//button[1])[2]")
    public WebElement JsConfirm;
    @FindBy(xpath = "(//button[1])[3]")
    public WebElement JsPrompt;
    @FindBy(xpath = "//p[@id='result']")
    public WebElement ResultText;
}
