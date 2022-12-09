package com.test.localhost.tests;

import com.test.localhost.pages.FileDownloadPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest(){
        FileDownloadPage fileDownloadPage=new FileDownloadPage(driver);
        fileDownloadPage.clickButton();
        fileDownloadPage.downloadButton();

    }
}
