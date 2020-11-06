package Tests;

import PageRepositories.FileDownloader;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners({ UITestListeners.class })
public class FileDownloaderTest extends BaseTest {
    @Test(priority=1)
    @Description("Click File Link to Download")
    @Severity(SeverityLevel.NORMAL)
    @Feature("File Downloader")
    public void click_file_link_to_download() throws IOException {
        FileDownloader fileDownloader = new FileDownloader(driver);
        String download_dir = System.getProperty("user.dir") + File.separator + "Downloads";
        FileUtils.cleanDirectory(new File(download_dir));

        fileDownloader.navigate_to_download_page(base_url);
        fileDownloader.validate_download_page_header();
        fileDownloader.click_file_link_to_download();
        fileDownloader.custom_wait(2000);
        fileDownloader.check_download_file_in_the_download_folder(download_dir);
    }
}
