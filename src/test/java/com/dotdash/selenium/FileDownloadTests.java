package com.dotdash.selenium;

import com.dotdash.selenium.pages.FileDownloadPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FileDownloadTests extends SetUpTearDown {
    HomePage homePage;
    FileDownloadPage fileDownloadPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        fileDownloadPage = new FileDownloadPage(driver);
    }

    @After
    public void tearDown() {
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/some-file.txt";
        File file = new File(path);
        file.delete();
    }

    @Test
    public void verifyFloatingMenuIsDisplayedAfterScrollDown() throws InterruptedException {
        homePage.clickFileDownloadLink();
        fileDownloadPage.clickDownloadLink();
        Thread.sleep(5000);
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/some-file.txt";
        File file = new File(path);
        Assert.assertTrue(file.exists());
    }
}
