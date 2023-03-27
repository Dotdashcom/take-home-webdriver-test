package pages;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage {

    @FindBy(css = "div.example > a")
    protected WebElement textFileLink;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void downloadFile() {
        textFileLink.click();
        pauseInSeconds(2);
    }

    public boolean isFileDownloaded() {
        String pathSeperator = "";

        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            pathSeperator = "\\";
        } else if(System.getProperty("os.name").toLowerCase().contains("mac os")) {
            pathSeperator = "/";
        }
        String downloadedFileAbsPath = Paths.get("test-files").toAbsolutePath() + pathSeperator + "some-file.txt";
        System.out.println(downloadedFileAbsPath);
        File fileWithFullPath = new File(downloadedFileAbsPath);
        return fileWithFullPath.exists();
    }
}
