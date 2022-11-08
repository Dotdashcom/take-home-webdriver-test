package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDragPage {
    WebDriver driver;

    //Initializing the page Objects
    public DropDragPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void dropdrag(){
        driver.get("http://localhost:7080/drag_and_drop");
        //Actions class method to drag and drop
        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();
    }


}
