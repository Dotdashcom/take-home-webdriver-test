package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest extends BasePage {


    protected FileUploadPage fileUploadPage;

    @BeforeTest
    public void setUp(){
        driver = getDriver();
        fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);
    }

    @Test
    public void fileUploadTest(){
        fileUploadPage.getFileUploadPage();
        fileUploadPage.uploadFile();
        Assert.assertEquals(fileUploadPage.getFileUploadedMessage().getText(),"File Uploaded!");
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }

}
