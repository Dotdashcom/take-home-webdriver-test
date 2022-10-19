package com.dotdash.tests;

import com.dotdash.pages.FileUploadPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test11_FileUpload {

    /**
     * Test uses Upload Button or Drag and Drop to upload a file.
     * Test asserts that the file is uploaded.
     */

    //TODO change "file.path" and/or "file.name" to file you want to upload in configuration.properties if needed

    @Test
    public void fileUploadButtonTest() {

        FileUploadPage fileUploadPage = new FileUploadPage();

        String url = ConfigurationReader.getProperty("base.url") + "/upload";
        Driver.getDriver().get(url);

        String filePath = ConfigurationReader.getProperty("file.path");
        fileUploadPage.chooseFile.sendKeys(filePath);
        fileUploadPage.uploadBtn.click();

        Assert.assertEquals(fileUploadPage.message.getText(), "File Uploaded!");
        Assert.assertTrue(fileUploadPage.uploadedFiles.getText().contains(ConfigurationReader.getProperty("file.name")));

        Driver.closeDriver();
    }

}
