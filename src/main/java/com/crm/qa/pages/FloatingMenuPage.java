package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
    WebDriver driver;

    @FindBy(linkText="Elemental Selenium")
    WebElement element;

    @FindBy(id="menu")
    WebElement menu;

    //Initializing the page Objects
    public FloatingMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String FloatingMenu(){
        driver.get("http://localhost:7080/floating_menu");
        scrollIntoView(element,driver );
        String message  = menu.getText();
      return  message;
    }


    //scroll until view something (NOT WORKING)
    public static void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }



}
