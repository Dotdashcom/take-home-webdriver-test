package com.dotdash.selenium;

import com.dotdash.selenium.pages.FileDownloadPage;
import com.dotdash.selenium.pages.FileUploadPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUploadTests extends SetUpTearDown {
    HomePage homePage;
    FileUploadPage fileUploadPage;

    @Before
    public void init() throws IOException {
        homePage = new HomePage(driver);
        fileUploadPage = new FileUploadPage(driver);
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/upload-file.txt";
        File file = new File(path);
        file.createNewFile();
    }

    @After
    public void tearDown() {
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/upload-file.txt";
        File file = new File(path);
        file.delete();
    }

    @Test
    public void verifyFloatingMenuIsDisplayedAfterScrollDown() throws InterruptedException {
        homePage.clickFileUploadLink();
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/upload-file.txt";
        fileUploadPage.clickChooseFile(path);
        Thread.sleep(3000);
        fileUploadPage.clickUpload();
        Assert.assertEquals(fileUploadPage.getHeader(), "File Uploaded!");
    }
}
