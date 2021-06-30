package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.FileUploadPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest_11 extends BaseClass {

    @Test
    public void FileUploadTest() {
        driver.get(baseURL);
        FileUploadPage fileUpload = new FileUploadPage(driver);

        fileUpload.clickUploadPageLink();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploader");
        fileUpload.setUploadPath();
        fileUpload.clickUploadButton();
        fileUpload.waitForMessage(); // assertion in the FileUploadPage.java
    }
}
