package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DownloadPage;

public class DownloadPageTest extends TestConfiguration {
    @Test
    @Parameters({"baseUrl", "downloadUrl","downloadPath"})
    public void file_Download_Test(String baseUrl, String downloadUrl, String downloadPath) {
        DownloadPage downloadPage = new DownloadPage(driver);
        downloadPage.goToUrl(baseUrl , downloadUrl);

        downloadPage.downLoadFile();
        Assert.assertTrue(downloadPage.checkFileDownloaded(downloadPath));
    }
}
