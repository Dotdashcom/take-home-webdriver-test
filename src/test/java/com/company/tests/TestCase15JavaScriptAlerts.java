package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test Clicks on JS Alert Button.
 * Test asserts alert message.
 * Test clicks on JS confirm Button and clicks ok on alert.
 * Test asserts the alert message.
 * Test clicks on JS Prompt Button and types a message on Prompt.
 * Test asserts that the alert message contains the typed message.
 */

public class TestCase15JavaScriptAlerts {

    @Test
    public void javaScriptAlerts() {

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");
        /*
         Test Clicks on JS Alert Button.
         Test asserts alert message.
         */

        WebElement jsAlertBtn = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        WebElement resultText = Driver.getDriver().findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText = "You successfuly clicked an alert";
        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly!");

        /*
         Test clicks on JS confirm Button and clicks ok on alert.
         Test asserts the alert message.
         */

        /*
         Dismiss case
         */

        WebElement jsConfAlertBtnDismiss = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsConfAlertBtnDismiss.click();

        alert.dismiss();

        WebElement resultText2 = Driver.getDriver().findElement(By.id("result"));

        Assert.assertTrue(resultText2.isDisplayed(), "Result text did not displayed!");

        String actualResultText2 = resultText.getText();
        String expectedResultText2 = "You clicked: Cancel";
        Assert.assertEquals(actualResultText2, expectedResultText2, "Result text did not appear correctly!");

        /*
         Accept case
         */

        WebElement jsConfAlertBtnAccept = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsConfAlertBtnAccept.click();

        alert.accept();

        WebElement resultText3 = Driver.getDriver().findElement(By.id("result"));

        Assert.assertTrue(resultText3.isDisplayed(), "Result text did not displayed!");

        String actualResultText3 = resultText.getText();
        String expectedResultText3 = "You clicked: Ok";
        Assert.assertEquals(actualResultText3, expectedResultText3, "Result text did not appear correctly!");


        /*
         Test clicks on JS Prompt Button and types a message on Prompt.
         Test asserts that the alert message contains the typed message.
         */
        /*
         Prompt case
         */

        WebElement jsPromptAlertBtn = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsPromptAlertBtn.click();

        String name = "Victor Wladowski";

        alert.sendKeys(name);

        alert.accept();

        WebElement resultText4 = Driver.getDriver().findElement(By.id("result"));

        Assert.assertTrue(resultText4.isDisplayed(), "Result text did not displayed!");

        String actualResultText4 = resultText4.getText();
        String expectedResultText4 = "You entered: Victor Wladowski";
        Assert.assertEquals(actualResultText4, expectedResultText4, "Result text did not appear correctly!");

        Assert.assertTrue(actualResultText4.contains(name));


        /*
         Dismiss case
         */

        WebElement jsPromptAlertBtnDismiss = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsPromptAlertBtnDismiss.click();

        alert.dismiss();

        WebElement resultText5 = Driver.getDriver().findElement(By.id("result"));

        Assert.assertTrue(resultText5.isDisplayed(), "Result text did not displayed!");

        String actualResultText5 = resultText.getText();
        String expectedResultText5 = "You entered: null";
        Assert.assertEquals(actualResultText5, expectedResultText5, "Result text did not appear correctly!");

        Driver.closeDriver();
    }
}

