package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadTest extends Util{

    protected FileDownloadPage fileDownloadPage;

    @BeforeTest
    public void setUp(){
        driver = getDriver();
        fileDownloadPage = PageFactory.initElements(driver, FileDownloadPage.class);
    }

    @Test
    public void file_Download(){
        Assert.assertEquals(fileDownloadPage.fileDownload(),prop.getProperty("filePath"));
    }

    @AfterTest
    public void endTest(){
    	teardown();
    }
}