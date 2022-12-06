package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.FileDownloadPage;

import java.io.File;

public class FileDownloadTest extends TestBase{

    FileDownloadPage fileDownloadPage;

    public FileDownloadTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/download");
        fileDownloadPage = new FileDownloadPage();
    }

    @Test()
    public void verifyFileDownload() throws InterruptedException {
        fileDownloadPage.clickLinkText();

        File f = new File("C:\\Users\\rezas\\Downloads\\some-file.txt");
        Thread.sleep(1000);
        Assert.assertTrue(f.exists());
        f.delete();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
