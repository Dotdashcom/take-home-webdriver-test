package com.homewebdriver.test;

import com.homewebdriver.webpages.DropdownPage;
import com.homewebdriver.webpages.DynamicContentPage;
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

public class DynamicContentTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
         String path = System.getProperty("user.dir");
 System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void dynamicContentTest() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        List<String> beforeContent = dynamicContentPage.getContentsInPage();
        driver.navigate().refresh();
        List<String> afterContent = dynamicContentPage.getContentsInPage();
        Assert.assertNotEquals(beforeContent,afterContent);

    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
