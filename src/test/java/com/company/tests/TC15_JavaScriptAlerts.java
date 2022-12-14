package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Alert alert = driver.switchTo().alert();
 * // if Alert comes from JS we use the Alert class
 * alert.accept(); // --> click "Ok" on popup
 * alert.dismiss(); // --> click "Cancel" on popup
 * alert.getText();  // --> to get text from popup
 * alert.sendKeys("text"); // --> to send text
 */

/**
 * Test Clicks on JS Alert Button.
 * Test asserts alert message.
 * Test clicks on JS confirm Button and clicks ok on alert.
 * Test asserts the alert message.
 * Test clicks on JS Prompt Button and types a message on Prompt.
 * Test asserts that the alert message contains the typed message.
 */

public class TC15_JavaScriptAlerts extends TestBase {

    @Test
    public void javaScriptAlerts() {

        driver.get("http://localhost:7080/javascript_alerts");
        /**
         Test Clicks on JS Alert Button.
         Test asserts alert message.
         */

        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed(), "Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText = "You successfuly clicked an alert";
        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly!");

        /**
         Test clicks on JS confirm Button and clicks ok on alert.
         Test asserts the alert message.
         */

        /**
         Dismiss case
         */

        WebElement jsConfAlertBtnDismiss = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsConfAlertBtnDismiss.click();

        alert.dismiss();

        WebElement resultText2 = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText2.isDisplayed(), "Result text did not displayed!");

        String actualResultText2 = resultText.getText();
        String expectedResultText2 = "You clicked: Cancel";
        Assert.assertEquals(actualResultText2, expectedResultText2, "Result text did not appear correctly!");

        /**
         Accept case
         */

        WebElement jsConfAlertBtnAccept = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsConfAlertBtnAccept.click();

        alert.accept();

        WebElement resultText3 = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText3.isDisplayed(), "Result text did not displayed!");

        String actualResultText3 = resultText.getText();
        String expectedResultText3 = "You clicked: Ok";
        Assert.assertEquals(actualResultText3, expectedResultText3, "Result text did not appear correctly!");


        /**
         Test clicks on JS Prompt Button and types a message on Prompt.
         Test asserts that the alert message contains the typed message.
         */
        /**
         Prompt case
         */

        WebElement jsPromptAlertBtn = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsPromptAlertBtn.click();

        String name = "Victor Wladowski";

        alert.sendKeys(name);

        alert.accept();

        WebElement resultText4 = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText4.isDisplayed(), "Result text did not displayed!");

        String actualResultText4 = resultText4.getText();
        String expectedResultText4 = "You entered: Victor Wladowski";
        Assert.assertEquals(actualResultText4, expectedResultText4, "Result text did not appear correctly!");

        Assert.assertTrue(actualResultText4.contains(name));


        /**
         Dismiss case
         */

        WebElement jsPromptAlertBtnDismiss = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsPromptAlertBtnDismiss.click();

        alert.dismiss();

        WebElement resultText5 = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText5.isDisplayed(), "Result text did not displayed!");

        String actualResultText5 = resultText.getText();
        String expectedResultText5 = "You entered: null";
        Assert.assertEquals(actualResultText5, expectedResultText5, "Result text did not appear correctly!");

    }
}

