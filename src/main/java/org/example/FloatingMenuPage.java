package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingMenuPage extends BasePage{

    protected WebDriver driver;
    By floatingMenuPage = By.cssSelector("[href='\\/floating_menu']");
    By homeIcon = By.cssSelector("[href='\\#home']");
    By contactIcon = By.cssSelector("[href='\\#contact']");

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFloatingMenuPage(){
        return driver.findElement(floatingMenuPage);
    }
    public WebElement getHomeIcon(){
        return driver.findElement(homeIcon);
    }
    public WebElement getContactIcon(){
        return driver.findElement(contactIcon);
    }

    public void scrollPage(){
        getFloatingMenuPage().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }

}
