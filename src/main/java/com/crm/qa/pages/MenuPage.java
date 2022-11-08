package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    WebDriver driver;

    @FindBy(id="hot-spot")
    WebElement element;


    //Initializing the page Objects
    public MenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String contextMenu(){

        driver.get("http://localhost:7080/context_menu");
        Actions action = new Actions(driver);  //right click
        WebElement link = element; // select the element
        action.contextClick(link).perform(); // click
        Alert alert = driver.switchTo().alert(); // use the alert method and swichTo for get the alert box
        String text = alert.getText();
      return text;
    }



}
