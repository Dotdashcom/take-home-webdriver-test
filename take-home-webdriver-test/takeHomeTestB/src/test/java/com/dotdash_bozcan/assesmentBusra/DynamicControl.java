package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControl {

    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/dynamic_controls");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }
    /*
   Dynamic Controls:  Dynamic Controls using Explicit Waits.
     */

    @Test
    public void dynamicControlsRemoveAdd() {
        WebElement removeAddButton = Driver.get().findElement(By.cssSelector("button[type='button'][onclick='swapCheckbox()']"));
        removeAddButton.click();

        WebElement actualTextBox =Driver.get().findElement(By.xpath("//p[@id='message']"));

        WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
        wait.until(ExpectedConditions.visibilityOf(actualTextBox));

        String expectedText = "It's gone!";
        System.out.println("expectedText = " + expectedText);
        String actualText = actualTextBox.getText();
        System.out.println("actualText = " + actualText);

        Assert.assertTrue(actualText.contains(expectedText));
    }


    @Test
    public void dynamicControlsEnableDisable() {

        WebElement enableOrdisable = Driver.get().findElement(By.xpath("//form[@id='input-example']/button"));
        enableOrdisable.click();

        WebElement inputBox = Driver.get().findElement(By.xpath("//form[@id='input-example']/input[@type='text']"));

        WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("hello world");

        String expectedText = "It's enabled!";
        String actualText = Driver.get().findElement(By.xpath("//p[@id='message']")).getText();

        Assert.assertTrue(actualText.contains(expectedText));
    }

}

