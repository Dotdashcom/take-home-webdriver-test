package tests;

import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest{
    @Test
    public void fileUpload() {
        HomePage homepage = new HomePage(driver);
        FileUploadPage fileUpload = homepage.clickFileUpload();
        fileUpload.uploadFile();
        assertEquals(fileUpload.uploadMessage(), "File Uploaded!");
    }
}
