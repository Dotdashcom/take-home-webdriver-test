package tests;

import enums.Pages;
import enums.Paths;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
import utilities.BrowserUtils;
import utilities.FileUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FileDownloadTest extends TestBase {

    @Test(description = "File downloader")
    public void fileDownloaderTest() {
        FileDownloadPage fileDownloadPage = new FileDownloadPage();
        BrowserUtils.openPage(driver, Pages.FILE_DOWNLOADER_PAGE);
        BrowserUtils.waitUntilVisible(driver, fileDownloadPage.header, Duration.ofSeconds(15));
        fileDownloadPage.downloadBtn.click();
        assertThat(
                FileUtils.isFilePresent(Paths.DOWNLOAD_FOLDER,
                        fileDownloadPage.downloadBtn.getText())).isTrue();
    }
}
