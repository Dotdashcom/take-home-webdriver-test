package tests;

import org.testng.annotations.Test;
import pages.FileDownloadPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest{
    @Test
    public void fileDownload() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        FileDownloadPage fileDownload = homepage.clickFileDown();
        fileDownload.clickOnFile();
        assertTrue(fileDownload.checkFileIsDownloaded());
    }
}
