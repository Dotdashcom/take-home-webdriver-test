package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingMenuPage extends Util{

    protected WebDriver driver;
    
    // selectors
    private By floatingMenuPage = By.cssSelector("[href='\\/floating_menu']");
    private By homeIcon = By.cssSelector("[href='\\#home']");
    private By contactIcon = By.cssSelector("[href='\\#contact']");

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFloatingMenuPage(){
        driver.findElement(floatingMenuPage).click();;
    }
    public WebElement getHomeIcon(){
        return driver.findElement(homeIcon);
    }
    public WebElement getContactIcon(){
        return driver.findElement(contactIcon);
    }

    public void scrollPage(){
        openFloatingMenuPage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }

}