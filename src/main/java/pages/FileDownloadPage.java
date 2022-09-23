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
        boolean isDownloaded = false;

        String dir = Paths.get("upload-download").toAbsolutePath().toString();
        String fileName = "some-file.txt";
        String fullPath = "";

        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            fullPath = String.format("%s%s%s", dir, "\\", fileName);
        } else if(System.getProperty("os.name").toLowerCase().contains("mac os")) {
            fullPath = String.format("%s%s%s", dir, "/", fileName);
        }

        File fileWithFullPath = new File(fullPath);
        return fileWithFullPath.exists();
    }
}
