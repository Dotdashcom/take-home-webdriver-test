package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.FileUploadPage;

public class FileUploadTest extends TestBase{

    FileUploadPage fileUploadPage;

    public FileUploadTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/upload");
        fileUploadPage = new FileUploadPage();
    }

    @Test()
    public void verifyFileUpload(){
        fileUploadPage.clickChooseFileBtn();
        fileUploadPage.clickUpload();
        Assert.assertEquals(fileUploadPage.verifyFileUpload(),"ToUpload.txt");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
