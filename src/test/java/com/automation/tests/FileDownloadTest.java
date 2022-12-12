package com.automation.tests;

import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest{

    @Test
    public void test(){
        fileDownloadPage.clickOnLink();
        fileDownloadPage.download();
    }
}
