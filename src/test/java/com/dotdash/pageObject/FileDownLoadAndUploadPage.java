package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDownLoadAndUploadPage {
    String upload="//input[@value='Upload']";

    public void downloadFile(String fileName) {
        I.amPerforming().click("//a[text()='"+fileName+"']");
    }

    public void uploadFile(String fileName) {
        I.amPerforming().input("//input[@id='file-upload']", System.getProperty("user.dir") + File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+File.separator+File.separator+fileName);
        I.amPerforming().click(upload);
    }

    public void assertFileUploaded(String fileName){
        I.amPerforming().threadWait(1000);
       Assert.assertEquals(I.amPerforming().getText("//*[contains(text(),'"+fileName+"')]"),fileName);
    }

    public void assertFileDownloaded(String fileName){
        I.amPerforming().threadWait(5000);
        Assert.assertTrue(Files.exists(Path.of(System.getProperty("user.dir") + File.separatorChar + "target/"+fileName)));
    }
}
