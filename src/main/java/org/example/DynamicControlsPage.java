package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DynamicControlsPage extends BasePage{

    protected WebDriver driver;
    By dynamicControlsPage = By.cssSelector("[href='\\/dynamic_controls']");
    By addButton = By.cssSelector("form#checkbox-example > button[type='button']");
    By enableButton = By.cssSelector("form#input-example > button[type='button']");
    By checkbox = By.cssSelector("[type='checkbox']");
    By textbox = By.cssSelector("[type='text']");
    By successMessage = By.cssSelector("p#message");
    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getDynamicControlsPage(){
        return driver.findElement(dynamicControlsPage);
    }
    public WebElement getAddButton(){
        return driver.findElement(addButton);
    }
    public WebElement getEnableButton(){
        return driver.findElement(enableButton);
    }
    public WebElement getCheckBox(){
        return driver.findElement(checkbox);
    }
    public WebElement getTextBox(){
        return driver.findElement(textbox);
    }
    public WebElement getsuccessMessage(){
        return driver.findElement(successMessage);
    }
    public void removeOrAddButton(){

        getDynamicControlsPage().click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(getAddButton()));
        getAddButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(getAddButton()));
        wait.until(ExpectedConditions.visibilityOf(getsuccessMessage()));
        Assert.assertEquals(getsuccessMessage().getText(),"It's gone!");
        getAddButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(getAddButton()));
        wait.until(ExpectedConditions.visibilityOf(getsuccessMessage()));
        Assert.assertEquals(getsuccessMessage().getText(),"It's back!");
    }


    public void enableTextField(){

        getDynamicControlsPage().click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(getEnableButton()));
        getEnableButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(getEnableButton()));
        wait.until(ExpectedConditions.visibilityOf(getsuccessMessage()));
        Assert.assertEquals(getsuccessMessage().getText(),"It's enabled!");
        getEnableButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(getEnableButton()));
        wait.until(ExpectedConditions.visibilityOf(getsuccessMessage()));
        Assert.assertEquals(getsuccessMessage().getText(),"It's disabled!");
    }

}
