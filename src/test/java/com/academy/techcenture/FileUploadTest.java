package com.academy.techcenture;

import com.academy.techcenture.pages.FileUploadPage;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseClassTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        FileUploadPage fileUploadPage = new FileUploadPage(driver, softAssert);
        fileUploadPage.navigateTo("/upload");
        fileUploadPage.verifyUploadFile();
    }

}
