package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlertTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/javascript_alerts");
    }

    @Test
    public void javascriptAlertsTest(){

        WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        WebElement jsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        jsAlert.click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        driver.switchTo().alert().dismiss();

        jsConfirm.click();
        String confirmText = driver.switchTo().alert().getText();
        Assert.assertEquals(confirmText, "I am a JS Confirm");
        driver.switchTo().alert().accept();

        jsPrompt.click();
        String keys = "Wooden Spoon";
        driver.switchTo().alert().sendKeys(keys);
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(result.getText().contains(keys));





    }
}
