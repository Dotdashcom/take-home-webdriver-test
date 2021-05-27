package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void javaScriptAlertTest(){

        //Locator of js alert button and I click it.
        WebElement jsAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        //I'm using alert class here. with alert class i can handle js popup. And i accept/OK js popup
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        String expectedText1 = "You successfuly clicked an alert";
        String actualText1 = Driver.getDriver().findElement(By.id("result")).getText();

        //Checking expected text and actual text.
        Assert.assertTrue(expectedText1.equals(actualText1));


        //Locator of js confirm button and I click it.
        WebElement jsConfirm = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        //I accept/OK js confirm popup
        alert.accept();
        String expectedText2 = "You clicked: Ok";

        //Here i cancel/dismiss the popup
        // alert.dismiss();
        // String expectedText2 = "You clicked: Cancel";

        String actualText2 = Driver.getDriver().findElement(By.id("result")).getText();

        //Checking actualResult with expectedResult
        Assert.assertTrue(expectedText2.equals(actualText2));

      //  WebElement resultText = Driver.getDriver().findElement(By.id("result"));


        WebElement jsPrompt = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        alert.sendKeys("Oguzhan Gurgen");
        alert.accept();

        String expectedText3 = "Oguzhan Gurgen";
        String actualText3 = Driver.getDriver().findElement(By.id("result")).getText();

        Assert.assertTrue(actualText3.contains(expectedText3));





    }

}
