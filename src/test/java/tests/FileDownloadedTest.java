package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.FileDownLoad;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadedTest extends BasePage {
    FileDownLoad fd;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.fileDownload);
        fd=new FileDownLoad();
    }
    @Test
    public boolean downloadFile()
    {
        return fd.isFileDownloaded("some-file.txt");
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}

