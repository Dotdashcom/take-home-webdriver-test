package com.academy.techcenture;

import com.academy.techcenture.pages.FileDownloadPage;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseClassTest {

    @Test
    public void dynamicLoadingTest() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver, softAssert);
        fileDownloadPage.navigateTo("/download");
        fileDownloadPage.verifyDownloadFile();
    }

}
