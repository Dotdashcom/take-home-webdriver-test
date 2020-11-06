package Tests;

import PageRepositories.FileUpload;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Listeners({ UITestListeners.class })
public class FileUploaderTest extends BaseTest {
    @Test(priority=1)
    @Description("Upload File from Download Folder")
    @Severity(SeverityLevel.NORMAL)
    @Feature("File Uploader")
    public void click_file_link_to_download() throws AWTException {
        FileUpload fileUpload = new FileUpload(driver);
        //Upload file from the Downloads folder.
        String download_dir = System.getProperty("user.dir") + File.separator + "Downloads";

        fileUpload.navigate_to_upload_page(base_url);
        fileUpload.validate_upload_page_header();
        fileUpload.upload_file_from_download_folder(download_dir);
        fileUpload.verify_file_is_uploaded();
    }
}
