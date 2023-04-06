package com.homewebdriver.test;

import com.homewebdriver.webpages.DynamicLoadingPage;
import com.homewebdriver.webpages.FileUploadPage;
//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;
//
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    public static WebDriver driver;
    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void fileUploadTest() throws InterruptedException {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.clickFileLinkToUpload();
        fileUploadPage.clickUploadButton();
        Assert.assertEquals(fileUploadPage.getUploadedSuccessMessage(),"File Uploaded!");
        Assert.assertEquals(fileUploadPage.getUploadedFileText(),"some-file.txt");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
