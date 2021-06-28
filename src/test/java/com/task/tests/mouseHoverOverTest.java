package com.task.tests;

import com.task.pages.mouseHoverOverPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mouseHoverOverTest {

    mouseHoverOverPage mouseHoverOverPage = new mouseHoverOverPage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/hovers");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void mouseHoverOver () throws InterruptedException {

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(mouseHoverOverPage.image1).build().perform();
        Assert.assertTrue( mouseHoverOverPage.additionalContent1.isDisplayed() );

        Thread.sleep(2000);

        actions.moveToElement(mouseHoverOverPage.image2).build().perform();
        Assert.assertTrue( mouseHoverOverPage.additionalContent2.isDisplayed() );

        Thread.sleep(2000);

        actions.moveToElement(mouseHoverOverPage.image3).build().perform();
        Assert.assertTrue( mouseHoverOverPage.additionalContent3.isDisplayed() );

    }




}
