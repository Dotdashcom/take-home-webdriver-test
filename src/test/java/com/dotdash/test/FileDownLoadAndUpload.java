package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDownLoadAndUpload extends TestBase {
    @Test(testName="Validate file is upload")
    public void validateFileUpload(){
        CommonMethods.navigateTo("upload");
        CommonMethods.input(fileDownLoadAndUploadPage.fileUpload, "/Users/sakirsahin/Desktop/OnlineAssessment/Project/src/test/uploadingtest.txt");
        CommonMethods.click(fileDownLoadAndUploadPage.upload);
        CommonMethods.threadWait(1000);
        Assert.assertEquals(CommonMethods.getText(fileDownLoadAndUploadPage.uploadVerify),"uploadingtest.txt");
    }

    @Test
    public void validateFileDownload(){
        CommonMethods.navigateTo("download");
        CommonMethods.click(fileDownLoadAndUploadPage.download);
        CommonMethods.threadWait(5000);
        Assert.assertTrue(Files.exists(Path.of("/Users/sakirsahin/Downloads/some-file.txt")));
    }
}