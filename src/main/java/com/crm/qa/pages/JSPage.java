package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JSPage {
    WebDriver driver;


    //Initializing the page Objects
    public JSPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void JSAlert(){
        driver.get("http://localhost:7080/javascript_alerts");

        //FIRTS BUTTON
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button")).click();
        Alert alert = driver.switchTo().alert(); // use the alert method and swichTo for get the alert box
        System.out.println(alert.getText()); // i get text of alert

        String text = alert.getText();
        Assert.assertEquals(text,"I am a JS Alert" );
        alert.accept();


        //SECOND BUTTON
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();
        Alert alert2 = driver.switchTo().alert(); // use the alert method and swichTo for get the alert box
        System.out.println(alert2.getText()); // i get text of alert

        String text2 = alert.getText();
        Assert.assertEquals(text2,"I am a JS Confirm" );
        alert2.accept();


        //THIRD BUTTON
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button")).click();
        Alert alert3 = driver.switchTo().alert(); // use the alert method and swichTo for get the alert box
        System.out.println(alert3.getText()); // i get text of alert

        String text3 = alert.getText();
        Assert.assertEquals(text3,"I am a JS prompt" );
        alert3.sendKeys("You must choose me"); //Write message
        alert3.accept();

    }

    public void JSError(){
        driver.get("http://localhost:7080/javascript_error");

        LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
        System.out.println("Print all log "+jsErrors.getAll());
        System.out.println("print index 0 log "+jsErrors.getAll().get(0));

        Assert.assertTrue(jsErrors.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));

    }

}
