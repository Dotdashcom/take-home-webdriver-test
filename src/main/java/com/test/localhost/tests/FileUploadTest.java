package com.test.localhost.tests;

import com.test.localhost.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest(){
        FileUploadPage fileUploadPage=new FileUploadPage(driver);
        fileUploadPage.clickFileUpload();
        fileUploadPage.clickChooseButton("/Users/kutmanzhanasharov/Desktop/kg.png");
       fileUploadPage.clickUploadButton();
        Assert.assertEquals(fileUploadPage.getText(),"File Uploaded!");



    }
}
