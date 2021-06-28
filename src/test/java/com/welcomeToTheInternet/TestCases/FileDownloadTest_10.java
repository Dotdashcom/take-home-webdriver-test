package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest_10 extends BaseClass {

    @Test
    public void FileDownloadTest() throws InterruptedException {
        driver.get(baseURL);
        FileDownloadPage downloadPage = new FileDownloadPage(driver);

        downloadPage.clickDownloadPageLink();
        downloadPage.clickDownloadFileLink();
    }
}
