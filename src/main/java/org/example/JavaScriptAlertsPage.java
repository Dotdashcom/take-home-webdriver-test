package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlertsPage extends BasePage{

    protected WebDriver driver;
    By javaScriptAlertsPage = By.cssSelector("[href='\\/javascript_alerts']");
    By jsAlertButton = By.cssSelector("[onclick='jsAlert\\(\\)']");
    By jsConfirmButton = By.cssSelector("[onclick='jsConfirm\\(\\)']");
    By jsPrompt = By.cssSelector("[onclick='jsPrompt\\(\\)']");
    By alertMessage = By.cssSelector("p#result");
    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getJavaScriptAlertsPage(){
        return driver.findElement(javaScriptAlertsPage);
    }
    public WebElement getJSAlertButton(){
        return driver.findElement(jsAlertButton);
    }
    public WebElement getJSConfirmButton(){
        return driver.findElement(jsConfirmButton);
    }
    public WebElement getJSPrompt(){
        return driver.findElement(jsPrompt);
    }
    public WebElement getAlertMessage(){
        return driver.findElement(alertMessage);
    }
    public String jsAlertClick(){

        getJavaScriptAlertsPage().click();
        getJSAlertButton().click();
        driver.switchTo().alert().accept();
        return getAlertMessage().getText();
    }

    public String jsConfirmClick(){

        getJavaScriptAlertsPage().click();
        getJSConfirmButton().click();
        driver.switchTo().alert().accept();
        return getAlertMessage().getText();
    }

    public String jsPromptClick(){

        getJavaScriptAlertsPage().click();
        getJSPrompt().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("text message");
        alert.accept();
        System.out.println(getAlertMessage());
        return getAlertMessage().getText();
    }



}
