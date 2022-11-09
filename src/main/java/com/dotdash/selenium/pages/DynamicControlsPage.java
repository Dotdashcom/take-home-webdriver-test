package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    @FindBy(id="checkbox")
    WebElement checkbox;

    @FindBy(css="form[id*=\"checkbox\"] button")
    WebElement removeAddButton;

    @FindBy(css="form[id*=\"input\"] input")
    WebElement textInput;

    @FindBy(css="form[id*=\"input\"] button")
    WebElement enabledDisabledButton;

    @FindBy(id="message")
    WebElement message;


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void removeCheckbox(){
        checkbox.isDisplayed();
        checkbox.click();
        removeAddButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(removeAddButton));
    }

    public String getMessage(){
        return message.getText();
    }

    public void addCheckbox(){
        removeAddButton.isEnabled();
        removeAddButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(removeAddButton));
    }

    public boolean isCheckboxPresent(){
        try{
            return checkbox.isDisplayed();
        } catch (Throwable e){
            return false;
        }
    }

    public void enableTextInput(){
        enabledDisabledButton.isDisplayed();
        enabledDisabledButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textInput));
    }

    public boolean isTextInputEnabled(){
        return textInput.isEnabled();
    }

    public void disableTextInput(){
        enabledDisabledButton.isDisplayed();
        enabledDisabledButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enabledDisabledButton));
    }

}
