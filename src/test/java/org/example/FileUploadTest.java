package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BasePage {


    protected FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);
    }

    @Test
    public void fileUploadTest(){
        fileUploadPage.getFileUploadPage();
        fileUploadPage.uploadFile();
        Assert.assertEquals(fileUploadPage.getFileUploadedMessage().getText(),"File Uploaded!");
        teardown();
    }

}
