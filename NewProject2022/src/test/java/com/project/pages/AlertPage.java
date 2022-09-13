package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    public AlertPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    public WebElement JsAlert;

    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    public WebElement JsConfirm;

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    public WebElement JsPrompt;

    @FindBy(xpath = "//p[@id='result']")
    public WebElement result;

}
