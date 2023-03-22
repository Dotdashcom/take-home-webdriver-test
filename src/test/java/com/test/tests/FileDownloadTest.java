package com.test.tests;

import com.test.pages.FileDownloadPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileDownloadTest extends TestBase {

    @Test
    public void testFileDownload() {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        fileDownloadPage.clickFileLink();
        assertTrue(!fileDownloadPage.isFileDownloaded());
    }
}
