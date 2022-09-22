package com.mitt.test;

import com.mitt.pages.FileDownloadPage;
import com.mitt.pages.FileUploadPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTests extends BaseTest{

    FileUploadPage fileUploadPage;

    @BeforeClass
    public void setUp(){
        fileUploadPage = new FileUploadPage(getDriver(), getWait());
    }

    @Test
    public void uploadFileTest(){
        fileUploadPage.file_upload();
    }
}
