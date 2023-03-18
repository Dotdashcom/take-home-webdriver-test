package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.FileDownloadPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownloadTest extends BasePage {
    public WebDriver driver;
    FileDownloadPage fileDownloadPage;

    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("downloadUrl"));
    }

    @Test
    public void validateFileDownload(){
        fileDownloadPage= new FileDownloadPage(driver);
        fileDownloadPage.downloadFileAndVerifyFileExists();

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
