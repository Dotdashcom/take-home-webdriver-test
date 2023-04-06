package com.homewebdriver.test;

import com.homewebdriver.webpages.CheckBoxPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckBoxTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
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

    @AfterTest
    public void close(){
        driver.close();
    }
}
