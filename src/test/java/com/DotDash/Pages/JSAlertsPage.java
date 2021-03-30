package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertsPage {

    public WebDriver ldriver;

    public JSAlertsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    WebElement btnJSAlert;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    WebElement btnJSConfirm;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    WebElement btnJSPrompt;

    @FindBy(id = "result")
    public WebElement txtresult;

    public void clkbtnJSAlert() {
        btnJSAlert.click();
    }

    public void clkbtnJSConfirm() {
        btnJSConfirm.click();
    }

    public void clkbtnJSPrompt() {
        btnJSPrompt.click();
    }

    public String gettxtresult() {
        return txtresult.getText();
    }


}
