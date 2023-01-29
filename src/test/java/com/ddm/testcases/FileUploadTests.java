package com.ddm.testcases;

import com.ddm.pageobjects.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests extends BaseTestClass {

    protected FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUpMethodFileUpload() {
        fileUploadPage = landingPage.goTo("/upload", FileUploadPage.class);
    }

    @Test
    public void FileUploadTest() {
        // Create a sample text file and upload
        fileUploadPage.uploadSampleFile();
        Assert.assertTrue(fileUploadPage.isUploadSuccess(), "File upload failed.");
    }
}
