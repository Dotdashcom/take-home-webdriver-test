package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class NewWindowPage extends BasePage{

    protected WebDriver driver;

    By windowPage = By.cssSelector("[href='\\/windows']");
    By clickHereOption = By.cssSelector("div#content  a[target='_blank']");

    By newWindowText = By.cssSelector("h3");
    public NewWindowPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getWindowPage(){
        return driver.findElement(windowPage);
    }

    public String getNewWindowText(){
        return driver.findElement(newWindowText).getText();
    }

    public WebElement getClickHereOption(){
        return driver.findElement(clickHereOption);
    }

    public void NewWindow(){

        getWindowPage().click();
        getClickHereOption().click();
        ArrayList<String> windowsHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(1));
    }
}
