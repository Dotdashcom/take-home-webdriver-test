package TakeHome.tests;

import TakeHome.pages.DownloadPage;
import org.testng.annotations.Test;

public class DownloadTest extends TestBase {

    @Test(groups = "Download")
    public void DownloadsText() {
        DownloadPage page = new DownloadPage();
        page.downloadText();
    }
}
