package com.homewebdriver.test;

import com.homewebdriver.webpages.DynamicContentPage;
import com.homewebdriver.webpages.DynamicControlsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicControlsTest {

   public static WebDriver driver;
    @BeforeTest
    public void setup(){
         String path = System.getProperty("user.dir");
 System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void dynamicControlsTest() throws InterruptedException {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        Assert.assertTrue(dynamicControlsPage.verifyAddAndRemoveCheckbox());
        Assert.assertTrue(dynamicControlsPage.verifyEnableAndDisable());

    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
