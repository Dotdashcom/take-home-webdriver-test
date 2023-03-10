package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage extends BasePage {

    protected WebDriver driver;
    By dynamicLoadingPage = By.cssSelector("[href='\\/dynamic_loading']");
    By example2 = By.cssSelector("[href='\\/dynamic_loading\\/2']");
    By startButton = By.cssSelector("div#start > button");

    By helloWorldText = By.cssSelector("div#finish > h4");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getDynamicLoadingPage(){
        return driver.findElement(dynamicLoadingPage);
    }
    public WebElement getExample2Page(){
        return driver.findElement(example2);
    }
    public WebElement getStartButton(){
        return driver.findElement(startButton);
    }

    public WebElement getHelloWorldText(){
        return driver.findElement(helloWorldText);
    }
    public void clickStartButton(){
        getDynamicLoadingPage().click();
        getExample2Page().click();
        getStartButton().click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(helloWorldText));
    }





}
