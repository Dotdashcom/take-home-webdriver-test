package download_file_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.download_file_page.DownloadPage;

import static org.testng.Assert.assertTrue;

public class DownloadTest extends Base {

    @Test
    public void downloadTest() throws InterruptedException {
        DownloadPage downloadPage = new DownloadPage();
        downloadPage.downloadFile();

        assertTrue(downloadPage.checkFileDownloaded());
    }
}
