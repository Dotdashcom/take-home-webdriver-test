package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void dynamicLoading(){
        //locator of start button and i clicked it
        WebElement startButton = Driver.getDriver().findElement(By.xpath("//*[.='Start']"));
        startButton.click();

        //locator of hello world text
        WebElement helloWorldText = Driver.getDriver().findElement(By.id("finish"));

        //with explicit wait i waited till hello world text appeared
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        String expectedText = "Hello World!";
        String actualText = helloWorldText.getText();

        // Checking expected result with actual result.
        Assert.assertEquals(actualText,expectedText);



    }

}
