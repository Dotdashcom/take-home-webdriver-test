package com.hired.tests;

import com.hired.pages.BasePage;
import com.hired.pages.FileUploadPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BasePage {
public WebDriver driver;
FileUploadPage fileUploadPage;
    @BeforeMethod
    public void setUp()  {
        driver= getDriver();
        driver.get(prop.getProperty("uploadUrl"));

    }

    @Test
    public void validateFileUpload() {
        fileUploadPage= new FileUploadPage(driver);
        fileUploadPage.uploadFile();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
