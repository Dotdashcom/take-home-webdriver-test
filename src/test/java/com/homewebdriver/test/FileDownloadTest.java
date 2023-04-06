package com.homewebdriver.test;

import com.homewebdriver.webpages.FileDownloadPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FileDownloadTest {
    public static WebDriver driver;
    @BeforeTest
    public void setup(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void fileDownloadTest() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        fileDownloadPage.clickFileLinkToDownload();
        Thread.sleep(10000);
    }

    @AfterTest
    public void close(){
        driver.close();
    }


}
