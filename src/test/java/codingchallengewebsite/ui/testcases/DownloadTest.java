package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.DownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadTest extends UITest {

    public DownloadTest() { }

    @Test(description = "Downloads a file and compares it with what's expected")
    public void fileDownload() {
        // Validate page loaded
        DownloadPage downloadPage = new DownloadPage(this);
        Assert.assertTrue(downloadPage.isPageOpen(), "Page not open");

        // Validate file download success
        Assert.assertTrue(downloadPage.fileDownload());
    }
}