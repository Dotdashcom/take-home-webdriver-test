package pages;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import  java.nio.file.Path;
import java.time.Duration;

public class FileDownloadPage extends BasePage {
    private String path = "/download";

    private By fileDownloadLinkBy = By.xpath("//a[contains(text(), 'some-file.txt')]");
    private String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
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
        // Initialize path for download location
        Path dir = Paths.get(downloadPath);

        try {
            DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir);

            for (Path entry: dirStream) {
                File file = entry.toFile();
                // Verify the file contains the file name, the appropriate extension,
                // Was modified after the download was started,
                // and does not contain crdownload, which meanas download is still in progress
                if (file.getName().contains(fileName) && file.getName().contains(fileExtension)
                        && file.lastModified() > downloadStartTime && !fileName.contains("crdownload")) {
                    // Keep track of the downloaded file
                    downloadedFile = file;
                    return true;
                }
            }

        } catch (Exception e) {
            // If there was an exception, most likely something failed and
            // the file won't be found
            return false;
        }
        // If it never returned true, it did not find the file
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
