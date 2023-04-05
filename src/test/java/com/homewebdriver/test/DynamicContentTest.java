package com.homewebdriver.test;

import com.homewebdriver.webpages.DropdownPage;
import com.homewebdriver.webpages.DynamicContentPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicContentTest {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dynamicContentTest() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        List<String> beforeContent = dynamicContentPage.getContentsInPage();
        driver.navigate().refresh();
        List<String> afterContent = dynamicContentPage.getContentsInPage();
        Assert.assertNotEquals(beforeContent,afterContent);

    }

    @After
    public void close(){
        driver.close();
    }
}
