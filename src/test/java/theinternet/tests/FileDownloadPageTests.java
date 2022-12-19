package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.FileDownloadPage;

public class FileDownloadPageTests extends BaseTest{
    FileDownloadPage fileDownloadPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToFileDownloadPage();
        fileDownloadPage = new FileDownloadPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testPageLanding(){
        Assert.assertTrue(fileDownloadPage.validatePageLanding(), "File download page not loaded");
    }

    @Test(priority = 1)
    public void testFileDownload() throws InterruptedException {
        fileDownloadPage.clickDownload();
        Assert.assertTrue(fileDownloadPage.checkDownloadFile());
    }
}
