package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.FileDownloadPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_10_FileDownload extends TestBase {

    @Test
    public void file_download_test() {
        FileDownloadPage fileDownloadPage = new FileDownloadPage();
        fileDownloadPage.navigatePages("File Download");

            fileDownloadPage.txtFile.click();
        try {
            boolean isFileExist = false;
            if(fileDownloadPage.file_exist("C:\\Users\\netta\\Downloads\\some-file.txt")) {
                isFileExist = true;
            }else {
                isFileExist = false;
            }

          Assertions.assertEquals(true, isFileExist, "File not downloaded");


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
