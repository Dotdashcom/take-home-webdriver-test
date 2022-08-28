package com.project.pom.test;

import com.project.pom.page.FileUpload;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileUploadTest {

    private WebDriver driver;
    FileUpload fileUpload;

    @Before
    public void setUp(){
        fileUpload = new FileUpload(driver);
        driver = fileUpload.chromeDriverConnection();
        fileUpload.visit("/upload");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        fileUpload.fileUpload();
        assertEquals("some-file.txt", fileUpload.fileUploadSuccess());
    }

    @After
    public void end(){ driver.quit(); }
}
