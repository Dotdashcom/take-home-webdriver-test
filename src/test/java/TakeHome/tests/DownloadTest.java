package TakeHome.tests;

import TakeHome.pages.DownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadTest extends TestBase {

    @Test(groups = "Download")
    public void DownloadsText() {
        DownloadPage page = new DownloadPage();
        page.downloadText();

        File file= new File("C:/Users/mysah/Downloads/some-file.txt");

        Assert.assertTrue(file.exists(),
                "Downloaded file does not exists in the specified directory or the same file is downloaded multiple times");

    }
}
