package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FileDownloadPage;
import testComponents.BaseTest;

public class FileDownloadTest extends BaseTest {


    @Test
    public void fileDownload() throws InterruptedException {
        FileDownloadPage fileDownloadPage=new FileDownloadPage(driver);
        fileDownloadPage.goTo();

        fileDownloadPage.clickOnFile();
        Thread.sleep(10000);
        Assert.assertTrue(fileDownloadPage.verifyTheFile());
    }
}
