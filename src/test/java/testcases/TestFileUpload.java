package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.FileUploadPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;



public class TestFileUpload {
    FileUploadPage fileUploadPage = new FileUploadPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "upload";
        Driver.getDriver().get(url);
    }

    @Test
    public void testFileUpload() {
        String pathToTheFile = "/Users/saianadashieva/Downloads/";
        String fileName = "some-file.txt";
        fileUploadPage.chooseFileBtn.sendKeys(pathToTheFile + fileName);
        BrowserUtils.highlightElement(fileUploadPage.chooseFileBtn);
        fileUploadPage.uploadBtn.click();
        BrowserUtils.highlightElement(fileUploadPage.uploadBtn);
        Assert.assertEquals("File Uploaded!", fileUploadPage.confirmMsg.getText());
    }


    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}

