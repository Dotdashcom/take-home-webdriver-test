package com.example.demo;

import pages.FileDownloadPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T10FileDownload extends TestMain{
    FileDownloadPage fileDownloadPage;

    @Test
    public void testFileDownload() throws InterruptedException{
        fileDownloadPage = new FileDownloadPage(driver);
        fileDownloadPage.clickFile();
        Thread.sleep(5000);
        Assert.assertTrue(fileDownloadPage.isFileDownloaded("some-file.txt"));
    }
}
