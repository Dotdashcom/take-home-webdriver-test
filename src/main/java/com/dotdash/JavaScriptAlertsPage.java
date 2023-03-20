package com.dotdash;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlertsPage extends Util{

    protected WebDriver driver;
    
    //selectors
    private By javaScriptAlertsPage = By.cssSelector("[href='\\/javascript_alerts']");
    private By jsAlertButton = By.cssSelector("[onclick='jsAlert\\(\\)']");
    private By jsConfirmButton = By.cssSelector("[onclick='jsConfirm\\(\\)']");
    private By jsPrompt = By.cssSelector("[onclick='jsPrompt\\(\\)']");
    private By alertMessage = By.cssSelector("p#result");
    
    /**
     * 
     * @param driver
     */
    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void openAlertsPage(){
        driver.findElement(javaScriptAlertsPage).click();
    }
    
    public void openalertButton(){
        driver.findElement(jsAlertButton).click();
    }
    
    public void getJSPrompt(){
        driver.findElement(jsPrompt).click();
    }
    
    public WebElement getJSConfirmButton(){
        return driver.findElement(jsConfirmButton);
    }
   
    public WebElement getAlertMessage(){
        return driver.findElement(alertMessage);
    }
    public String jsAlertClick(){

        openAlertsPage();
        openalertButton();
        driver.switchTo().alert().accept();
        return getAlertMessage().getText();
    }

    public String jsConfirmClick(){

    	openAlertsPage();
        getJSConfirmButton().click();
        driver.switchTo().alert().accept();
        return getAlertMessage().getText();
    }

    public String jsPromptClick(){

    	openAlertsPage();
        getJSPrompt();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("text message");
        alert.accept();
        return getAlertMessage().getText();
    }



}