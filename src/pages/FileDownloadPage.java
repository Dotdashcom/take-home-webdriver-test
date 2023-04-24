package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileDownloadPage extends BasePage {
    private String path = "/download";

    private By fileDownloadLinkBy = By.xpath("//a[contains(text(), 'some-file.txt')]");
    private String downloadPath = System.getProperty("user.home") + File.separator + "downloads";
    private String fileName = "some-file";
    private String fileExtension = ".txt";

    private File downloadedFile = null;

    public FileDownloadPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void clickFileDownloadLink() {
        driver.findElement(fileDownloadLinkBy).click();
    }

    public boolean fileDownloaded(long downloadStartTime) {
        File[] files = new File(downloadPath).listFiles();

        for (File file : files) {
            if (file.getName().contains(fileName) && file.getName().contains(fileExtension)
                    && file.lastModified() > downloadStartTime && !fileName.contains("crdownload")) {
                downloadedFile = file;
                return true;
            }
        }
        return false;
    }

    public boolean waitForDownload(int timeoutSec, int intervals, long downloadStartTime) {
        int passedSec = 0;
        boolean fileDownloaded = false;

        while (!fileDownloaded && timeoutSec > passedSec) {
            try {
                Thread.sleep(Duration.ofSeconds(intervals));
            } catch(InterruptedException e) {
                System.out.println("Interrupted sleep.");
            }
            passedSec += intervals;
            fileDownloaded = fileDownloaded(downloadStartTime);
        }

        return fileDownloaded;
    }

    public void deleteDownloadedFile() {
        if (downloadedFile != null) {
            downloadedFile.delete();
        }
    }
}
