package com.dotdash.testcases;

import com.dotdash.pageObject.FileDownLoadAndUploadPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class FileDownLoadAndUpload extends Setup{
    FileDownLoadAndUploadPage fileDownLoadPage;

    public FileDownLoadAndUpload(){
     this.fileDownLoadPage = MyTestClasses.getObject(FileDownLoadAndUploadPage.class);
    }

    @Test(testName="Validate file is uploadd")
    public void validateFileUpload(){
        navigateTo("upload");
        fileDownLoadPage.uploadFile("uploadingtest.txt");
        fileDownLoadPage.assertFileUploaded("uploadingtest.txt");

    }


    public void validateFileDownload(){
        navigateTo("download");
        fileDownLoadPage.downloadFile("some-file.txt");
        fileDownLoadPage.assertFileDownloaded("some-file.txt");
    }
}
