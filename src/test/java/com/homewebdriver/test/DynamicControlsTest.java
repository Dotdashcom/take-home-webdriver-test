package com.homewebdriver.test;

import com.homewebdriver.webpages.DynamicContentPage;
import com.homewebdriver.webpages.DynamicControlsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicControlsTest {

   public static WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dynamicControlsTest() throws InterruptedException {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        Assert.assertTrue(dynamicControlsPage.verifyAddAndRemoveCheckbox());
        Assert.assertTrue(dynamicControlsPage.verifyEnableAndDisable());

    }

    @After
    public void close(){
        driver.close();
    }
}
