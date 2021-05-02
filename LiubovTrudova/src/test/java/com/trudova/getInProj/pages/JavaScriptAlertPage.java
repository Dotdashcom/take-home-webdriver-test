package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPage extends BasePage{
    public JavaScriptAlertPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[.='Click for JS Alert']")
    public WebElement clickForJSAlertBtn;
    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    public WebElement clickForConfirmBtn;
    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    public WebElement clickForJSPrompt;
    @FindBy(id = "result")
    public WebElement resultMessage;

}
