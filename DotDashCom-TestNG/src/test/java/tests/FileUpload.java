package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import utilities.ConfigReader;
import utilities.Driver;

public class FileUpload {
    FileUploadPage fileUploadPage = new FileUploadPage();
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"upload");
        fileUploadPage.chooseFileLink.sendKeys("/Users/FURKAN/Downloads/some-file.txt");
        fileUploadPage.uploadButton.click();
        Assert.assertTrue(fileUploadPage.uploadedMessage.isDisplayed());
        Assert.assertTrue(fileUploadPage.uploadedFileName.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
