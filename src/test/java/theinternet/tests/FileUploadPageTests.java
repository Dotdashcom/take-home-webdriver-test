package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.FileUploadPage;

public class FileUploadPageTests extends BaseTest{
    FileUploadPage fileUploadPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToFileUploadPage();
        fileUploadPage = new FileUploadPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(fileUploadPage.validatePageLanding(), "File download page not loaded");
    }

    @Test(priority = 1)
    public void testFileUpload(){
        fileUploadPage.uploadFile();
        Assert.assertTrue(fileUploadPage.uploadSuccess());
    }
}
