package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.FileDownloadPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest_10 extends BaseClass {

    @Test
    public void FileDownloadTest() throws InterruptedException {
        driver.get(baseURL);
        FileDownloadPage downloadPage = new FileDownloadPage(driver);

        downloadPage.clickDownloadPageLink();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Downloader");
        downloadPage.clickDownloadFileLink();
        Assert.assertTrue(true);
    }
}
