package com.framework.testcases;

import com.framework.pages.DownloadPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadPageTest extends TestBase {
    DownloadPage downloadPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the download page page")
    public void user_is_on_download_page() {
        downloadPage = new DownloadPage(driver);
        downloadPage.navigate();
        String actualURL = downloadPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/download";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can download file")
    public void user_can_download_file() {
        downloadPage = new DownloadPage(driver);
        downloadPage.navigate().clickDownloadLink();
        Boolean isFileDownloaded = downloadPage.isFileDownloaded("some-file.txt");
        Assert.assertTrue(isFileDownloaded);
    }
}
