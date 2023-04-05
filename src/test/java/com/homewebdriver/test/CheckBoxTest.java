package com.homewebdriver.test;

import com.homewebdriver.webpages.CheckBoxPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxTest {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mvidh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCheckBoxes() throws InterruptedException {
        CheckBoxPage checkbox = new CheckBoxPage(driver);
        checkbox.clickCheckBox("One");
        Assert.assertEquals(checkbox.verifyCheckBoxStatus("One"),true);
        Assert.assertEquals(checkbox.verifyCheckBoxStatus("Two"),true);
        checkbox.clickCheckBox("Two");
        Assert.assertEquals(checkbox.verifyCheckBoxStatus("One"),true);
        Assert.assertEquals(checkbox.verifyCheckBoxStatus("Two"),false);
        checkbox.clickCheckBox("One");
        Assert.assertEquals(checkbox.verifyCheckBoxStatus("One"),false);
        Assert.assertEquals(checkbox.verifyCheckBoxStatus("Two"),false);
    }

    @After
    public void close(){
        driver.close();
    }
}
