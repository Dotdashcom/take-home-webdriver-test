package com.dotdash.tests;

import com.dotdash.pages.FileDownloadPage;
import com.dotdash.pages.TestBase;
import org.junit.Test;

public class FileDownloadTest extends TestBase {


    @Test
    public void fileDownloadTest() {
        FileDownloadPage fileDownloadPage = new FileDownloadPage();
        fileDownloadPage.navigatePages("File Download");

        fileDownloadPage.txtFile.click();

    }

}
