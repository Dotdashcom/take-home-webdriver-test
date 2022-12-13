package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15_JavaScriptAlerts extends TestBase {

    @Test
    public void InformationAlertTest(){
//        3. Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertBtn.click();

//        4. Click to OK button from the alert
        // driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        // accept() will click on OK button on JS Alert
        alert.accept();

//        5. Verify “You successfully clicked an alert” text is displayed.

        WebElement resultText = driver.findElement(By.id("result"));

        // asserTrue() method will check if inside argument is true or false
        Assert.assertTrue(resultText.isDisplayed(),"Result text did not displayed!");

        String actualResultText = resultText.getText();
        String expectedResultText ="You successfully clicked an alert";
        Assert.assertEquals(actualResultText,expectedResultText,"Result text did not appear correctly!");

    }
}
