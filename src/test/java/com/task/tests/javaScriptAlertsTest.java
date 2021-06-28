package com.task.tests;


import com.task.pages.javaScriptAlertsPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptAlertsTest {

    javaScriptAlertsPage javaScriptAlertsPage = new javaScriptAlertsPage();


    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/javascript_alerts");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }


    @Test
    public void javaScriptAlerts() throws InterruptedException {

        Thread.sleep(1000);
        javaScriptAlertsPage.jsAlertButton.click();
        String alertMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println("alert message :" + alertMessage);
        Assert.assertEquals( alertMessage , "I am a JS Alert" );
        Thread.sleep(2000);
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(1000);

        javaScriptAlertsPage.jsConfirmButton.click();
        String confirmMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println("confirm message : " + confirmMessage);
        Assert.assertEquals( confirmMessage , "I am a JS Confirm" );
        Thread.sleep(2000);
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(1000);

        javaScriptAlertsPage.jsPromptButton.click();
        String promptMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println("prompt message : " + promptMessage);
        Assert.assertEquals( promptMessage , "I am a JS prompt" );
        Thread.sleep(2000);
        Driver.getDriver().switchTo().alert().sendKeys("Prompt Message");
        Thread.sleep(1000);
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(3000);

    }

}
