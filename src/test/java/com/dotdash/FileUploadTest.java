package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest extends Util {


    protected FileUploadPage fileUploadPage;

    @BeforeTest
    public void setUp(){
        driver = getDriver();
        fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);
    }

    @Test
    public void file_Upload_Test(){
        fileUploadPage.openFileUploadPage();
        fileUploadPage.uploadFile();
        Assert.assertEquals(fileUploadPage.getFileUploadedMessage().getText(),"File Uploaded!");
    }
    
    @AfterTest
    public void endTest(){
    	teardown();
    }
}