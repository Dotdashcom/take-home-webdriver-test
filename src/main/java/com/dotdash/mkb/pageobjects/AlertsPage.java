package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AlertsPage extends BasePage {

    @FindBy(css = "#content > div.example > ul > li:first-child > button")
    private WebElement triggerAlertBtn;

    @FindBy(css = "#content > div.example > ul > li:nth-child(2) > button")
    private WebElement triggerConfirmBtn;

    @FindBy(css = "#content > div.example > ul > li:last-child > button")
    private WebElement triggerPromptBtn;

    @FindBy(id = "result")
    private WebElement alertResult;

    public AlertsPage(WebDriver driver) {
        super(driver);

    }
    public void triggerAlert(){
        triggerAlertBtn.click();
    }
    public void triggerConfirm(){
        triggerConfirmBtn.click();
    }
    public void triggerPrompt(){
        triggerPromptBtn.click();
    }
    public void acceptAlert(){
        getDriver().switchTo().alert().accept();
    }

    public void dismissAlert(){
        getDriver().switchTo().alert().dismiss();
    }

    public String geAlertText(){
        return getDriver().switchTo().alert().getText();
    }

    public void setInput(String text){
        getDriver().switchTo().alert().sendKeys(text);
    }

    public String getResult(){
        return alertResult.getText();
    }
}