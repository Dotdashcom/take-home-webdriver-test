package pages;

import java.io.File;

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
        String fullPath = "";

        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            fullPath = "\\";
        } else if(System.getProperty("os.name").toLowerCase().contains("mac os")) {
            fullPath = "/";
        }
        String downloadedFileAbsPath = System.getProperty("user.home") + fullPath + "Downloads/some-file.txt";
        File fileWithFullPath = new File(downloadedFileAbsPath);
        return fileWithFullPath.exists();
    }
}
