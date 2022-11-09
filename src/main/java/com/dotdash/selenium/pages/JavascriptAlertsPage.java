package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JavascriptAlertsPage extends BasePage {
    @FindBy(css="button")
    List<WebElement> alertButtons;

    @FindBy(id="result")
    WebElement message;

    public JavascriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertButton(){
        alertButtons.get(0).click();
    }

    public void clickConfirmButton(){
        alertButtons.get(1).click();
    }

    public void clickPromptButton(){
        alertButtons.get(2).click();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void typePrompt(String text){
        driver.switchTo().alert().sendKeys(text);
        acceptAlert();
    }

    public String getResultMessage(){
        return message.getText();
    }
}
