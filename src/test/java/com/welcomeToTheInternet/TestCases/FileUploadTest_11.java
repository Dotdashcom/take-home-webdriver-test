package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.FileUploadPage;
import org.testng.annotations.Test;

public class FileUploadTest_11 extends BaseClass {

    @Test
    public void FileUploadTest() {
        driver.get(baseURL);
        FileUploadPage fileUpload = new FileUploadPage(driver);

        fileUpload.clickUploadPageLink();
        fileUpload.setUploadPath();
        fileUpload.clickUploadButton();
        fileUpload.waitForMessage();
    }
}
