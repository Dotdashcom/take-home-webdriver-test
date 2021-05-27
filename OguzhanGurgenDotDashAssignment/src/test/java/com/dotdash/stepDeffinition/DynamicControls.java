package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/dynamic_controls");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void DynamicControlTest() {


        // In here I put webElements locators.
        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        WebElement removeButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[1]"));

        //In here I clicked checkBox then removeButton
        checkBox.click();
        removeButton.click();

        //In here locator of it's gone button
        WebElement itsGoneButton = Driver.getDriver().findElement(By.id("message"));
        //With explicitWait I waited till it's gone button appear.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(itsGoneButton));

        //I checked it's gone message showed up or not.
        Assert.assertEquals(itsGoneButton.getText(),"It's gone!");

        //add button's locator. I used index number 1 here because it was the first one.
        WebElement addButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[1]"));

        //I clicked add button
        addButton.click();

        //it's back button locator
        WebElement itsBack = Driver.getDriver().findElement(By.id("message"));

        //I waited till it's back button appear
        wait.until(ExpectedConditions.visibilityOf(itsBack));

        //Checking it's back button appeared and text is shown or not
        Assert.assertTrue(itsBack.isDisplayed());
        Assert.assertEquals(itsBack.getText(),"It's back!");




        //locator of input box
        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));

        //checking input box enabled or not
        Assert.assertTrue(!inputBox.isEnabled());

        //locator of enable button and I clicked it.
        WebElement enableButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        // waited till input box appear.
        wait.until(ExpectedConditions.visibilityOf(inputBox));

        //locator of it is enabled
        WebElement itIsEnabled = Driver.getDriver().findElement(By.xpath("//*[@id='message']"));


       // System.out.println(itIsEnabled.getText());

        //Checking it's enabled message shown or not
        Assert.assertEquals(itIsEnabled.getText(),"It's enabled!");

        //checking input box is enabled or not
        Assert.assertTrue(inputBox.isEnabled());

        //locator of disable button I used index number 2 here because it was the second one. and i clicked it.
        WebElement disableButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[2]"));
        disableButton.click();

        //locator of it's disabled button
        WebElement itIsDisabled = Driver.getDriver().findElement(By.id("message"));

        //waited till disabled button appeared
        wait.until(ExpectedConditions.visibilityOf(itIsDisabled));

        //checked button appeared or not
        Assert.assertTrue(!inputBox.isEnabled());


    }
}
