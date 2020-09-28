package LocalHost.Tests;

import LocalHost.Pages.DownloadPage;
import org.testng.annotations.Test;

public class Download extends TestingBase{

    @Test(groups = "Download")
    public void DownloadsText() {
        DownloadPage page = new DownloadPage();
        page.DownloadText();
    }
}
