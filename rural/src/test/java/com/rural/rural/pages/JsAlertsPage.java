package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/javascript_alerts
public class JsAlertsPage {
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement buttonClickForAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement buttonClickForConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement buttonClickFor;

    @FindBy(id = "result")
    public WebElement Result;

    



    public JsAlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
