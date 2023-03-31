package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileDownload;

public class FileDownloadTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/download ");
        FileDownload file = new FileDownload(driver);
        file.download(driver);
        Assert.assertTrue(file.isDownloaded());
    }

}
