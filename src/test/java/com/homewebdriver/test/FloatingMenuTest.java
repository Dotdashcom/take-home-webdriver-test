package com.homewebdriver.test;

import com.homewebdriver.webpages.FloatingMenuPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FloatingMenuTest {
    public static WebDriver driver;

    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void floatingMenuTest() {

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(0),"Home");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(1),"News");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(2),"Contact");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(3),"About");
        floatingMenuPage.scrollDown();
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(0),"Home");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(1),"News");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(2),"Contact");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(3),"About");
        floatingMenuPage.scrollUp();
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(0),"Home");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(1),"News");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(2),"Contact");
        Assert.assertEquals(floatingMenuPage.getMenusInPage().get(3),"About");

    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
