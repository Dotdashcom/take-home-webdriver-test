package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPage extends BasePage {

    public JavaScriptAlertPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement clickForJSAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement clickForJSConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement clickForJSPrompt;

    @FindBy(css = "#result")
    public WebElement resultMsg;

}
