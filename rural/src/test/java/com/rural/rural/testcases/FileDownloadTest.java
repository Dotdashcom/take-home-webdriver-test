package com.rural.rural.testcases;


import com.rural.rural.pages.DynamicLoadingPage;
import com.rural.rural.pages.FileDownloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileDownloadTest {
    private WebDriver driver;
    private FileDownloadPage fileDownloadPage;



    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/download");

        fileDownloadPage = new FileDownloadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void DynamicLoading() throws InterruptedException {

        fileDownloadPage.linkSomeFile.click();

        boolean flag=false;

        // Verify that the file exists in the download directory
        String downloadPath = "C:\\Users\\USUARIO\\Downloads";
        File file = new File(downloadPath + "\\some-file.txt");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(file.exists()) {
            System.out.println("File downloaded successfully.");
            flag=true;
        } else {
            System.out.println("File download failed.");
        }
        Assert.assertTrue(flag,"the file is not in the destination folder");
        file.delete();

        // close the browser
        driver.quit();

    }



}
