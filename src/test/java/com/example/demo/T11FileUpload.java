package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class T11FileUpload extends TestMain{
    FileUploadPage fileUploadPage;

    @Test
    public void testFileUpload(){
        String filePath = System.getProperty("user.dir") +"/src/some-file.txt";
        fileUploadPage = new FileUploadPage(driver);
        fileUploadPage.chooseFile(filePath);
        fileUploadPage.clickUploadBution();
        Assert.assertTrue(fileUploadPage.isUploaded());
    }
}
