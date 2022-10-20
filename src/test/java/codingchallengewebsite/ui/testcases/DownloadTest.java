package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.DownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadTest extends UITests {

    public DownloadTest() {
    }

    @Test(description = "Downloads a file and compares it's size with what's written in the headers")
    public void downloadTest() {
        DownloadPage downloadPage = new DownloadPage(this.driver, this);
        Assert.assertTrue(downloadPage.isPageOpen(), "Page not open");

        downloadPage.startFileDownload();
        Assert.assertTrue(downloadPage.validateFileDownload());
    }
}
