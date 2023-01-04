package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.FileDownloadPage;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class FileDownloadTest extends BaseTest {
    private FileDownloadPage fileDownloadPage;

    @BeforeMethod
    public void setup() {
        fileDownloadPage = homePage.gotoFileDownloadPage();
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        fileDownloadPage.clickFileDownloadLink();

        TimeUnit.SECONDS.sleep(3);
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads/";
        File downloadFolder = new File(downloadFolderPath);
        File[] downloadFolderFiles = downloadFolder.listFiles();
        boolean isFileDownloaded = false;

        for (File file : downloadFolderFiles) {
            if (file.isFile()) {
                if (file.getName().equals("some-file.txt")) {
                    isFileDownloaded = true;
                }
            }
        }
        Assert.assertTrue(isFileDownloaded, "File has not been downloaded!");
    }
}