package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class NewTabPage {
    WebDriver driver;


    //Initializing the page Objects
    public NewTabPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void newTab(){
        driver.get("http://localhost:7080/windows");

        driver.findElement(By.linkText("Click Here")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //Get name
        driver.switchTo().window(tabs.get(1)); //SwichToNewTab
        String message = driver.findElement(By.cssSelector(".example h3")).getText();
        Assert.assertEquals(message,"New Window");

    }

}
