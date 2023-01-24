package com.dotdash.test.parallel;

import com.dotdash.pageobject.FileDownloadPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownload extends BaseTest {

    private FileDownloadPage file_download_page = null;

    @BeforeMethod
    void init() {
        if (file_download_page == null) file_download_page = new FileDownloadPage(driver);
    }

    @Test
    void able_to_download_file() {
        file_download_page.click_on_file_link_to_download(); // included verification
    }

}
