package com.rural.rural.testcases;

import com.rural.rural.pages.FloatingMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FloatingMenuTest {
    private WebDriver driver;
    private FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/floating_menu");

        floatingMenuPage = new FloatingMenuPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void FloatingMenu() throws InterruptedException {


        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        // Get the current URL of the webpage
        floatingMenuPage.linkHome.click();
        String currentUrl = driver.getCurrentUrl();

        // Verify if the current URL matches the expected URL
        if (currentUrl.equals("http://localhost:7080/floating_menu#home")) {
            System.out.println("URL verified successfully");
            flag1=true;
        } else {
            System.out.println("URL verification failed");
        }

        Assert.assertTrue(flag1,"home url is not working properly");

        floatingMenuPage.linkNews.click();
        currentUrl = driver.getCurrentUrl();

        // Verify if the current URL matches the expected URL
        if (currentUrl.equals("http://localhost:7080/floating_menu#news")) {
            System.out.println("URL verified successfully");
            flag2=true;
        } else {
            System.out.println("URL verification failed");
        }

        Assert.assertTrue(flag2,"news url is not working properly");

        floatingMenuPage.linkContact.click();
        currentUrl = driver.getCurrentUrl();

        // Verify if the current URL matches the expected URL
        if (currentUrl.equals("http://localhost:7080/floating_menu#contact")) {
            System.out.println("URL verified successfully");
            flag3=true;
        } else {
            System.out.println("Contact verification failed");
        }

        Assert.assertTrue(flag3,"contact url is not working properly");

        floatingMenuPage.linkAbout.click();
        currentUrl = driver.getCurrentUrl();

        // Verify if the current URL matches the expected URL
        if (currentUrl.equals("http://localhost:7080/floating_menu#about")) {
            System.out.println("URL verified successfully");
            flag4=true;
        } else {
            System.out.println("URL verification failed");
        }

        Assert.assertTrue(flag4,"About url is not working properly");



        // close the browser
        driver.quit();

    }



}
