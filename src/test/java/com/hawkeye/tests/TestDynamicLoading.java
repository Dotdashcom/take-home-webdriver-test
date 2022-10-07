package com.hawkeye.tests;

import com.hawkeye.pages.DynamicLoadingPage;
import com.hawkeye.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDynamicLoading {

    DynamicLoadingPage load = new DynamicLoadingPage();

    @Test
    public void checkLoading(){

        Driver.getDriver().get("http://localhost:7080/dynamic_loading/2");

        Driver.getDriver().manage().window().maximize();

        load.startButton.click();

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),15);

        wait.until(ExpectedConditions.visibilityOf(load.HelloWorld));

        Assert.assertTrue(load.HelloWorld.isDisplayed());


        Driver.closeDriver();




    }








}
