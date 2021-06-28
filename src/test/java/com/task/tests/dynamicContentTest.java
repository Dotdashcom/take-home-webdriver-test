package com.task.tests;

import com.task.pages.dynamicContentPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicContentTest {

    dynamicContentPage dynamicContentPage = new dynamicContentPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/dynamic_content");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void dynamicContent() throws InterruptedException {

        String avatar1Message = dynamicContentPage.avatar1.getText();
        String avatar2Message = dynamicContentPage.avatar2.getText();
        String avatar3Message = dynamicContentPage.avatar3.getText();

        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        String avatar1MessageAfterFirstRefresh = dynamicContentPage.avatar11.getText();
        String avatar2MessageAfterFirstRefresh = dynamicContentPage.avatar22.getText();
        String avatar3MessageAfterFirstRefresh = dynamicContentPage.avatar33.getText();
        System.out.println( "avatar 1 message after first refresh :" + avatar1MessageAfterFirstRefresh);

        Assert.assertNotEquals(avatar1Message,avatar1MessageAfterFirstRefresh);
        Assert.assertNotEquals(avatar2Message,avatar2MessageAfterFirstRefresh);
        Assert.assertNotEquals(avatar3Message,avatar3MessageAfterFirstRefresh);

        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        String avatar1MessageAfterSecondRefresh = dynamicContentPage.avatar111.getText();
        String avatar2MessageAfterSecondRefresh = dynamicContentPage.avatar222.getText();
        String avatar3MessageAfterSecondRefresh = dynamicContentPage.avatar333.getText();

        Assert.assertNotEquals(avatar1MessageAfterFirstRefresh,avatar1MessageAfterSecondRefresh);
        Assert.assertNotEquals(avatar2MessageAfterFirstRefresh,avatar2MessageAfterSecondRefresh);
        Assert.assertNotEquals(avatar3MessageAfterFirstRefresh,avatar3MessageAfterSecondRefresh);

        Thread.sleep(1000);
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        String avatar1MessageAfterThirdRefresh = dynamicContentPage.avatar1111.getText();
        String avatar2MessageAfterThirdRefresh = dynamicContentPage.avatar2222.getText();
        String avatar3MessageAfterThirdRefresh = dynamicContentPage.avatar3333.getText();

        Assert.assertNotEquals(avatar1MessageAfterFirstRefresh,avatar1MessageAfterThirdRefresh);
        Assert.assertNotEquals(avatar2MessageAfterFirstRefresh,avatar2MessageAfterThirdRefresh);
        Assert.assertNotEquals(avatar3MessageAfterFirstRefresh,avatar3MessageAfterThirdRefresh);

    }














}
