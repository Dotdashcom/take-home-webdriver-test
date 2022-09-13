package com.project.tests;

import com.project.pages.AlertPage;
import com.project.utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlert {

    AlertPage alertPage=new AlertPage();

    @Test
    public void AlertTest() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/javascript_alerts");

        Driver.getDriver().manage().window().maximize();

        alertPage.JsAlert.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = Driver.getDriver().switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        Assert.assertEquals(alertPage.result.getText(),"You successfuly clicked an alert");

        alertPage.JsConfirm.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert2 = Driver.getDriver().switchTo().alert();

        alert2.accept();

        Assert.assertEquals(alertPage.result.getText(),"You clicked: Ok");

        alertPage.JsPrompt.click();
        Thread.sleep(2000);

        Alert alert3 = Driver.getDriver().switchTo().alert();

        alert3.sendKeys("Hello");

        alert3.accept();

        Assert.assertEquals(alertPage.result.getText(),"You entered: Hello");

        Driver.closeDriver();



    }
}
