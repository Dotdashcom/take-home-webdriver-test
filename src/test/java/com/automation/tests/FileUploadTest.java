package com.automation.tests;

import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    @Test
    public void test(){
        fileUploadPage.clickOnLink();
        fileUploadPage.upload();
    }
}
