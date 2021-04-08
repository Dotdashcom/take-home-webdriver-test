package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.FileDownloadPage;
import utils.ConfigReader;
import utils.Driver;

import java.io.File;

public class FileDownloadCase {
    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "download";
        Driver.getDriver().get(url);
    }

    @Test()
    public void testFileDownload() {
        fileDownloadPage.file.click();
        Assert.assertTrue(new File(System.getProperty("user.home")+"/Downloads/some-file.txt").exists());

    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
