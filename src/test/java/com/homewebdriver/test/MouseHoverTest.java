package com.homewebdriver.test;

import com.homewebdriver.webpages.IframePage;
import com.homewebdriver.webpages.MouseHoverPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseHoverTest {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void MouseHoverTest(){
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);
        Assert.assertEquals(mouseHoverPage.getContentFromMouseOverImages().get(0),"name: user1");
        Assert.assertEquals(mouseHoverPage.getContentFromMouseOverImages().get(1),"name: user2");
        Assert.assertEquals(mouseHoverPage.getContentFromMouseOverImages().get(2),"name: user3");
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
