package com.rural.rural.testcases;


import com.rural.rural.pages.FileUploadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest {
    private WebDriver driver;
    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/upload");

        fileUploadPage = new FileUploadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void FileUpload() throws InterruptedException {

        // Set the path to the file to be uploaded
        File fileToUpload = new File("src\\test\\resources\\CV_Victor_Haro.pdf");

        // Find the file input element and send the file path to it
        WebElement fileInput = fileUploadPage.inputFileUpload;
        fileInput.sendKeys(fileToUpload.getAbsolutePath());

        fileUploadPage.inputFileSubmit.click();
        boolean flag=false;


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Assert.assertTrue(fileUploadPage.msgFileUploaded.isDisplayed(),"the file was uplodaded succesfuly");

        // close the browser
        driver.quit();

    }



}
