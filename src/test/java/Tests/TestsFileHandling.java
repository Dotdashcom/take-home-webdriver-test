package Tests;

import Baseclass.BaseClass;
import Pages.FileDownloadingPage;
import Pages.FileUploadingPage;
import org.testng.annotations.Test;

public class TestsFileHandling extends BaseClass {

    @Test
    public void T012_File_Downloading_Testing() {
        FileDownloadingPage file_downloading_page = new FileDownloadingPage(driver);
        file_downloading_page.GoToFileDownloading();
        file_downloading_page.Download_File();
        file_downloading_page.AssertFileExists();

    }
    @Test
    public void T013_File_Uploading_Testing() {
        FileUploadingPage file_uploading_page = new FileUploadingPage(driver);
        file_uploading_page.GoToFileUploading();
        file_uploading_page.Upload_File();
        file_uploading_page.AssertFileWasUpload();

    }
}
