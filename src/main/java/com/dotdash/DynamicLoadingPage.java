package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage extends Util {

    protected WebDriver driver;
    
    //Selectors
    private By dynamicLoadingPage = By.cssSelector("[href='\\/dynamic_loading']");
    private By example2 = By.cssSelector("[href='\\/dynamic_loading\\/2']");
    private By startButton = By.cssSelector("div#start > button");

    private By text = By.cssSelector("div#finish > h4");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public void openDynamicLoadingPage(){
        driver.findElement(dynamicLoadingPage).click();
    }
    public void getExample2Page(){
        driver.findElement(example2).click();
    }
    public void getStartButton(){
        driver.findElement(startButton).click();
    }

    public WebElement getHelloWorldText(){
        return driver.findElement(text);
    }
    public void clickStartButton(){
    	openDynamicLoadingPage();
        getExample2Page();
        getStartButton();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(text));
    }

}