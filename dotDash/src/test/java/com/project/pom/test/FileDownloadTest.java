package com.project.pom.test;

import com.project.pom.page.FileDownload;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class FileDownloadTest {

    private WebDriver driver;
    FileDownload fileDownload;

    @Before
    public void setUp(){
        fileDownload = new FileDownload(driver);
        driver = fileDownload.chromeDriverConnection();
        fileDownload.visit("/download");
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        fileDownload.fileDownload();
    }

    @After
    public void end(){ driver.quit(); }
}
