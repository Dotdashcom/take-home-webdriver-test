package com.mitt.test;

import com.mitt.pages.DynamicLoadingPage;
import com.mitt.pages.FileDownloadPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownloadTests extends BaseTest{

    FileDownloadPage filedownloadPage;

    @BeforeClass
    public void setUp(){
        filedownloadPage = new FileDownloadPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu() throws InterruptedException {
        filedownloadPage.downloadFile();
    }
}
