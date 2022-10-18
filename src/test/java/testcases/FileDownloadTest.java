package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.FileDownloadPage;
import org.junit.Assert;
import org.junit.Test;

public class FileDownloadTest extends BaseTest {

    public FileDownloadTest(){
        super();
    }

    @Test
    public void DownloadFileAndAssertTheFileWasDownloaded() throws InterruptedException{

        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);

        fileDownloadPage.clickSomeFileHyperlink();
        Assert.assertTrue(isFileDownloaded("some-file.txt"));

    }
}
