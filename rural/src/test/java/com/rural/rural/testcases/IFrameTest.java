package com.rural.rural.testcases;


import com.rural.rural.pages.FileUploadPage;
import com.rural.rural.pages.IFramePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class IFrameTest {
    private WebDriver driver;
    private IFramePage iFramePage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/iframe");

        iFramePage = new IFramePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void IFrame()  {

        iFramePage.close.click();


        //Switch driver focus to the iframe with id="mce_0_ifr"
        driver.switchTo().frame("mce_0_ifr");

        // Locate the editable content area of the editor
        WebElement editorContent = driver.findElement(By.id("tinymce"));

        // Clear the existing text (optional)
        editorContent.clear();

        // Type new text into the editor content area
        editorContent.sendKeys("test");

        //Assert.assertTrue(iFramePage.chat.getText().equals("test"),"you can't type in the chat inside the iframe");

        // Switch driver focus back to the main page
        driver.switchTo().defaultContent();

        // close the browser
        driver.quit();

    }



}
