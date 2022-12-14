package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 Alert alert = driver.switchTo().alert();
 // if Alert comes from JS we use the Alert class
 alert.accept(); // --> click "Ok" on popup
 alert.dismiss(); // --> click "Cancel" on popup
 alert.getText();  // --> to get text from popup
 alert.sendKeys("text"); // --> to send text
 */

public class TC15_JavaScriptAlerts extends TestBase {

    @Test
    public void informationAlertTest(){

        driver.get("http://localhost:7080/javascript_alerts");
//      Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

//      Click to OK button from the alert
        // driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        // accept() will click on OK button on JS Alert
        alert.accept();

//      Verify “You successfully clicked an alert” text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));

        // asserTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultText.isDisplayed(),"Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText ="You successfuly clicked an alert";
        Assert.assertEquals(actualResultText,expectedResultText,"Result text did not appear correctly!");

    }

    @Test
    public void confirmationAlertTestDismiss() {

        driver.get("http://localhost:7080/javascript_alerts");

        WebElement jsConfAlertBtn = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsConfAlertBtn.click();

        // Cancel scenario
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement resultText = driver.findElement(By.id("result"));

        // asserTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultText.isDisplayed(), "Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText = "You clicked: Cancel";
        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly!");

    }

        @Test
        public void confirmationAlertTestAccept() {

            driver.get("http://localhost:7080/javascript_alerts");

            WebElement jsConfAlertBtn = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
            jsConfAlertBtn.click();

        // Ok scenario
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));

        // asserTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultText.isDisplayed(),"Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText ="You clicked: Ok";
        Assert.assertEquals(actualResultText,expectedResultText,"Result text did not appear correctly!");
    }


    @Test
    public void promptAlertTest() {

        driver.get("http://localhost:7080/javascript_alerts");

        WebElement jsPromptAlertBtn = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsPromptAlertBtn.click();

        String name ="Victor Wladowski";

        Alert alert = driver.switchTo().alert();
        // send name
        alert.sendKeys(name);

        // click OK
        alert.accept();

        // get message text
        WebElement resultText = driver.findElement(By.id("result"));

        // asserTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultText.isDisplayed(),"Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText ="You entered: Victor Wladowski";
        Assert.assertEquals(actualResultText,expectedResultText,"Result text did not appear correctly!");

        Assert.assertTrue(actualResultText.contains(name));
    }

    @Test
    public void promptAlertTestDismiss() {

        driver.get("http://localhost:7080/javascript_alerts");

        WebElement jsConfAlertBtn = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        jsConfAlertBtn.click();

        // Cancel scenario
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement resultText = driver.findElement(By.id("result"));

        // asserTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultText.isDisplayed(), "Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText = "You entered: null";
        Assert.assertEquals(actualResultText, expectedResultText, "Result text did not appear correctly!");

    }
}

