package com.task.tests;

import com.task.pages.iFramePage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {

    iFramePage iFramePage = new iFramePage();

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/iframe");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void iFrame() throws InterruptedException {


        Driver.getDriver().switchTo().frame("mce_0_ifr");

        Thread.sleep(1000);
        iFramePage.content.clear();
        Thread.sleep(1000);
        iFramePage.content.sendKeys("Hello World!!!");
        String text = iFramePage.content.getText();
        System.out.println( iFramePage.content.getText() );

        Assert.assertEquals( text , "Hello World!!!" );
        Thread.sleep(2000);

    }






}
