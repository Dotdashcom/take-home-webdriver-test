import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.FileDownloaderPage;

import java.io.File;
import java.util.Objects;

import static org.testng.AssertJUnit.assertEquals;

public class FileDownloader {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/download");
    }

    @Test(testName = "File Download")
    public void checkFileAppearsInDownloadDirectory() {
        File downloadsDirectory = new File("/Users/virajgandhi/Downloads/");
        int countFiles = Objects.requireNonNull(downloadsDirectory.listFiles()).length;
        FileDownloaderPage page = new FileDownloaderPage(driver);
        page.clickLinkToDownload();
        int countFilesLatest = Objects.requireNonNull(downloadsDirectory.listFiles()).length;
        assertEquals("Wrong file count displayed", countFilesLatest, countFiles);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
