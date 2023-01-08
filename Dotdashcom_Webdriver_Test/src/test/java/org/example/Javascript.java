package org.example;

import Resources.driverConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Hover;
import pageObjects.JavaScript;

import java.io.IOException;

public class Javascript extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "javascript_alerts");

    }

    @Test
    public void clickinbox() throws InterruptedException {
        JavaScript j = new JavaScript(driver);
        JavascriptExecutor js=(JavascriptExecutor)driver;

        Actions a=new Actions(driver);

        a.click(j.alertclick1()).build().perform();
        driver.switchTo().alert().accept();
        String s=j.endresult().getText();
        Assert.assertTrue(s.contains("clicked an alert"));

        a.click(j.alertclick2()).build().perform();
        driver.switchTo().alert().dismiss();
        s=j.endresult().getText();
        Assert.assertTrue(s.contains("Cancel"));



        a.click(j.alertclick3()).build().perform();
        driver.switchTo().alert().sendKeys("hi how are you");
        driver.switchTo().alert().accept();
        s=j.endresult().getText();
        Assert.assertTrue(s.contains("you"));

    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.close();
    }

}
