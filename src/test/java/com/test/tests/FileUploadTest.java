package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.test.pages.FileUploadPage;

public class FileUploadTest extends TestBase {


    private FileUploadPage fileUploadPage;

    @Test
    public void testFileUpload() {
        String filePath = "./ext/chromedriver.exe";
        fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.uploadFile(filePath);
        assertTrue(driver.getPageSource().contains("File Uploaded!"));
        driver.quit();
    }
}
