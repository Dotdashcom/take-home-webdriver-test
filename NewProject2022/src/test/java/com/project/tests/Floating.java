package com.project.tests;

import com.project.pages.FloatPages;
import com.project.utility.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Floating {

    FloatPages pages =new FloatPages();

    @Test
    public void FloatTest() throws InterruptedException {

        Driver.getDriver().get("http://localhost:7080/floating_menu");

        Driver.getDriver().manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1);
            js.executeScript("window.scrollBy(0,750)");

        }

        Assert.assertTrue(pages.floatingMenu.isDisplayed());


    }


}
