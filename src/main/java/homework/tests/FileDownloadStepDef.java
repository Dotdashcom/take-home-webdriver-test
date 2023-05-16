package homework.tests;

import homework.pages.DownloadPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadStepDef extends TestBase {

    DownloadPage downloadPage = new DownloadPage();

    @Test
    public void verifyDownloadFunctionality(){

        Driver.getDriver().get("http://localhost:7080/download");

        downloadPage.file.click();

        File downloadedFile = new File("/Users/jelena/Downloads/some-file.txt");

        Assert.assertTrue(downloadedFile.exists());
    }
}
