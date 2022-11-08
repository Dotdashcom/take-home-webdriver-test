package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

    WebDriver driver;


    //Initializing the page Objects
    public NotificationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String NotificationMessage(){
        driver.get("http://localhost:7080/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        String message = driver.findElement(By.id("flash-messages")).getText();
        return message;
    }

    public String NotificationMessage2(){
        driver.get("http://localhost:7080/notification_message_rendered");
        //DOUBLE CLICK
        WebElement doubleC = driver.findElement(By.linkText("Click here"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleC).build().perform();
        String message2 = driver.findElement(By.id("flash-messages")).getText();
        return  message2;
    }



}
