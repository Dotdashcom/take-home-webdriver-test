package com.internet.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class DynamicControlsPage extends BasePage{


    @FindBy(xpath = "//button[@onclick='swapCheckbox()']")
    private WebElement removeAndAddButton;

    @FindBy(id = "loading")
    private WebElement loadingIndicator;

    @FindBy(xpath = "//button[@onclick='swapInput()']")
    private WebElement enableAndDisableButton;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputField;

    @FindBy(id = "message")
    private WebElement message;

    public void clickRemoveAndAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(removeAndAddButton));
        removeAndAddButton.click();
        waitUntilLoadingIndicatorisGone();
    }

    public void clickEnableAndDisableButton(){
        wait.until(ExpectedConditions.elementToBeClickable(enableAndDisableButton));
        enableAndDisableButton.click();
        waitUntilLoadingIndicatorisGone();
        wait.until(ExpectedConditions.visibilityOf(message));

    }

    public boolean checkIfCheckbox()
    {
        List<WebElement> checkbox = driver.findElements(By.id("checkbox"));
        return checkbox.size() > 0;
    }

    public boolean checkIfFieldIsEnabled() throws InterruptedException {
        return inputField.isEnabled();
    }


    public void waitUntilLoadingIndicatorisGone(){
        wait.until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }



}
