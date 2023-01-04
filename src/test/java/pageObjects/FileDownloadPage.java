package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadPage extends Page {
    private static final By FILE_DOWNLOAD_LINK = By.partialLinkText(".txt");

    public FileDownloadPage(ChromeDriver driver) {
        super(driver);
    }

    public void clickFileDownloadLink() {
        click(FILE_DOWNLOAD_LINK, BasePage.TIMEOUT);
    }
}
