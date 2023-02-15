package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(13) > a")
    protected WebElement dynamicControlsButton;

    @FindBy(css = "#checkbox-example > button")
    protected WebElement addOrRemoveButton;

    @FindBy(css = "#checkbox-example > p")
    protected WebElement checkBoxMessage;

    @FindBy(css = "#input-example > button")
    protected WebElement enableOrDisableButton;

    @FindBy (css = "#input-example > p")
    protected WebElement inputFieldMessage;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToDynamicControlsPage() {
        dynamicControlsButton.click();
    }

    public void clickRemoveButton() {
        addOrRemoveButton.click();
    }

    public void clickAddButton() {
        addOrRemoveButton.click();
    }

   public String getCheckBoxMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(checkBoxMessage));
        return checkBoxMessage.getText();
   }

   public void clickEnableButton() {
        enableOrDisableButton.click();
   }

   public  void clickDisableButton() {
        enableOrDisableButton.click();
   }

    public String getInputFieldMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(inputFieldMessage));
        return inputFieldMessage.getText();
    }
}
