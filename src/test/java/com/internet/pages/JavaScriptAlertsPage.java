package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage{


    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement jsAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement jsConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement jsPrompt;

    @FindBy(id = "result")
    private WebElement resultMsg;

    public void clickJsAlert(){
        waitforVisibilityandClickable(jsAlert);
        jsAlert.click();
    }

    public void clickJsConfirm(){
        waitforVisibilityandClickable(jsConfirm);
        jsConfirm.click();
    }
    public void clickJsPrompt(){
        waitforVisibilityandClickable(jsPrompt);
        jsPrompt.click();
    }

    public boolean ifAlertMessageDisplayed(String message){
       if(driver.switchTo().alert().getText().equals(message)) {
           driver.switchTo().alert().accept();
           return true;

       }
       else
           return false;

    }
    public void writeToPrompt(String intro){
        driver.switchTo().alert().sendKeys(intro);
        driver.switchTo().alert().accept();
    }

    public String getPromptText(){
        return resultMsg.getText().substring(13);
    }



}
