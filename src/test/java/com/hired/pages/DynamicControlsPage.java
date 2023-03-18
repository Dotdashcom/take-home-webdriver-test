package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsPage {
    public WebDriver driver;
    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement dynCheckBox;
    @FindBy(xpath = "//button[normalize-space()='Remove']")
    public WebElement removeButton;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement addButton;
    @FindBy(xpath = "//p[@id='message']")
    public WebElement messageText;
    @FindBy(xpath = "//button[normalize-space()='Enable']")
    public WebElement enableButton;
    @FindBy(xpath = "//button[normalize-space()='Disable']")
    public WebElement disableButton;
    @FindBy(xpath="//form[@id='input-example']/input")
    public WebElement textfield;

    public void addRemoveCheckbox()  {
        dynCheckBox.click();
        removeButton.click();
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(messageText));
        String message= messageText.getText();
        Assert.assertEquals(message,"It's gone!");

        addButton.click();
        wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(dynCheckBox));
        Assert.assertTrue(dynCheckBox.isDisplayed());
    }

    public void enableDisableValidation() {
        enableButton.click();
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(textfield));
        Assert.assertEquals(textfield.isEnabled(),true);
        disableButton.click();
        wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(enableButton));
        String message= messageText.getText();
        Assert.assertEquals(message,"It's disabled!");
    }
}
