package com.rural.rural.testcases;


import com.rural.rural.pages.FileUploadPage;
import com.rural.rural.pages.MouseHoverPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class MouseHoverTest {
    private WebDriver driver;
    private MouseHoverPage mouseHoverPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/hovers");

        mouseHoverPage = new MouseHoverPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void MouseHover() throws InterruptedException {



        // Create an instance of the Actions class
        Actions actions = new Actions(driver);

        // Move the mouse to the element
        actions.moveToElement(mouseHoverPage.image1).perform();

        //Verify info
        Assert.assertTrue(mouseHoverPage.name1.isDisplayed(),"info 1 is not displayed");

        // Move the mouse to the element
        actions.moveToElement(mouseHoverPage.image2).perform();

        //Verify info
        Assert.assertTrue(mouseHoverPage.name2.isDisplayed(),"info 2 is not displayed");

        // Move the mouse to the element
        actions.moveToElement(mouseHoverPage.image3).perform();

        //Verify info
        Assert.assertTrue(mouseHoverPage.name3.isDisplayed(),"info 3 is not displayed");


        // close the browser
        driver.quit();

    }



}
