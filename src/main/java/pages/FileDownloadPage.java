package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;


public class FileDownloadPage extends AbstractWebPage {

    @FindBy(css = "div.example > a")
    protected WebElement textFileLinkElm;

    protected String downloadFileDir;
    protected String downloadFileName;
    protected String fileAbsPath;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
        downloadFileDir = Paths.get("downloads").toAbsolutePath().toString();
        downloadFileName = "some-file.txt";
        fileAbsPath = String.format("%s/%s", downloadFileDir, downloadFileName);
    }

    public void downloadFile() {
        textFileLinkElm.click();

        // Wait 10 seconds for file to downloaded.
        int timeOut = 10;
        File file = new File(fileAbsPath);
        while (!file.exists() && timeOut > 0) {
            sleepInSeconds(1);
            timeOut--;
        }
    }

    public boolean isFileDownloaded() {
        boolean isDownloaded = false;

        File dir = new File(downloadFileDir);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals(downloadFileName))
                isDownloaded = true;
        }
        return isDownloaded;
    }
}