package com.ddm.testcases;

import com.ddm.pageobjects.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownloadTests extends BaseTestClass {

    protected FileDownloadPage fileDownloadPage;

    @BeforeMethod
    public void setUpMethodFileDownload() {
        fileDownloadPage = landingPage.goTo("/download", FileDownloadPage.class);
    }

    @Test
    public void fileDownloadTest() {
        fileDownloadPage.downloadFile();
        Assert.assertTrue(fileDownloadPage.isFileDownloaded(), "File is NOT downloaded.");
    }
}
