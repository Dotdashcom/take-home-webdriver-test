package com.task.tests;

import com.task.pages.dynamicLoadingPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dynamicLoadingTest {

    dynamicLoadingPage dynamicLoadingPg = new dynamicLoadingPage();


    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void dynamicLoading() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        dynamicLoadingPg.startButton.click();

        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadingPg.loading));
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPg.helloWorldText));

        Assert.assertEquals( dynamicLoadingPg.helloWorldText.getText() , "Hello World!" );

    }






















}
