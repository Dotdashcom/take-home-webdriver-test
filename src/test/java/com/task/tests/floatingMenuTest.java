package com.task.tests;

import com.task.pages.floatingMenuPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class floatingMenuTest {

    floatingMenuPage floatingMenuPage = new floatingMenuPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/floating_menu");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void floatingMenu() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        Assert.assertTrue( floatingMenuPage.floatingMenu.isDisplayed() );
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

    }























}
