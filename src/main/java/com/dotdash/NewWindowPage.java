package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class NewWindowPage extends Util{

    protected WebDriver driver;

    private By windowPage = By.cssSelector("[href='\\/windows']");
    private By clickHereOption = By.cssSelector("div#content  a[target='_blank']");

    By newWindowText = By.cssSelector("h3");
    public NewWindowPage(WebDriver driver){
        this.driver = driver;
    }

    public void openWindowPage(){
        driver.findElement(windowPage).click();
    }

    public String getNewWindowText(){
        return driver.findElement(newWindowText).getText();
    }

    public void openClickHereOption(){
        driver.findElement(clickHereOption).click();
    }

    public void NewWindow(){

    	openWindowPage();
    	openClickHereOption();
        ArrayList<String> windowsHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(1));
    }
}