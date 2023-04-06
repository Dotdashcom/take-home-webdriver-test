package com.homewebdriver.test;

import com.homewebdriver.webpages.DynamicLoadingPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingTest {
    public static WebDriver driver;
    @BeforeTest
    public void setup(){
         String path = System.getProperty("user.dir");
      System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void dynamicControlsTest(){
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.clickStartButton();
        Assert.assertEquals(dynamicLoadingPage.getHelloWorldTextAfterLoading(),"Hello World!");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
