package com.company.tests;

import com.company.base.TestBase;
import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

/**
 Test clicks on the Remove Button and uses explicit wait.
 Test asserts that the checkbox is gone.
 Test clicks on Add Button and uses explicit wait.
 Test asserts that the checkbox is present.
 Test clicks on the Enable Button and uses explicit wait.
 Test asserts that the text box is enabled.
 Test clicks on the Disable Button and uses explicit wait.
 Test asserts that the text box is disabled.
 */

public class TestCase08DynamicControls{

    @Test
    public void dynamicControls(){

        Driver.getDriver().get("http://localhost:7080/dynamic_controls");

        WebElement RemoveAddButton = Driver.getDriver().findElement( By.xpath("//*[@id='checkbox-example']/button"));
        WebElement CheckBox = Driver.getDriver().findElement( By.xpath("//*[@id='checkbox']"));

        WebElement EnableDisableButton = Driver.getDriver().findElement( By.xpath("//*[@id='input-example']/button"));

        RemoveAddButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.invisibilityOf(CheckBox));

        Assert.assertFalse(CheckBox.isSelected(), "Checkbox is gone");

        Driver.closeDriver();
    }

    @Test
    public void dynamicContent() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

        // click on enable
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//button")).click();
        // WebDriverWait  class used to explicit waits
        // just creating object, waiting does not happen yet
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(4));
        // wait.until() : this is when wait happens
        // we are waiting for certain element this xpath to be clickable
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@type='text']")));
        // enter text
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("hello world");

        Driver.closeDriver();
    }

    @Test
    public void implicitWait2(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        // click on remove button
        Driver.getDriver().findElement(By.cssSelector("form#checkbox-example>button")).click();
        // print the message
        System.out.println(Driver.getDriver().findElement(By.id("message")).getText());

        // click on add button
        Driver.getDriver().findElement(By.cssSelector("form#checkbox-example>button")).click();
        // verify checkbox is displayed
        System.out.println(Driver.getDriver().findElement(By.id("checkbox")).isDisplayed());

        Driver.closeDriver();
    }

}
