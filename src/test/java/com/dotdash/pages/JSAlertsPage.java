package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlertsPage extends BasePage{

    @FindBy(css = "button[onclick='jsAlert()']")
    public WebElement alert;

    @FindBy(css = "button[onclick='jsConfirm()']")
    public WebElement confirm;

    @FindBy(css = "button[onclick='jsPrompt()']")
    public WebElement prompt;

    @FindBy(id = "result")
    public WebElement result;

}
