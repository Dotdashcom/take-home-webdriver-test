package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileDownloadPage extends BasePage {
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#content > div > a")
    private WebElement fileDownloadLink;

    public void downloadFile() {
        fileDownloadLink.click();
    }

    public boolean isDownloadedFileLocated() {
        String downloadedFile = System.getProperty("user.home") + "\\downloads\\some-file.txt";

        File file = new File(downloadedFile);
        waitUntilFileExists(file);
        return file.exists();
    }
}
