package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.FileDownload;

public class FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest(){
        String downloadPath = "/Users/firedoo/Downloads";
        FileDownload fileDownload = new FileDownload(driver);
        fileDownload.downloadFile(downloadPath);

    }
}
