package com.rural.rural.testcases;


import com.rural.rural.pages.DynamicLoadingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoadingTest {
    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;



    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/dynamic_loading/2");

        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void DynamicLoading() {

        dynamicLoadingPage.buttonStart.click();

        // Wait until the element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.HelloWorld));

        //Verify the text is present
        Assert.assertTrue(dynamicLoadingPage.HelloWorld.getText().equals("Hello World!"),"the page is loaded");


        // close the browser
        driver.quit();

    }



}
