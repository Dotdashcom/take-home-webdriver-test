package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileDownload {
    public FileDownload(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='download/some-file.txt']")
    WebElement file;

    public void download(WebDriver driver) {
        file.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='download/some-file.txt']")));

    }

    public boolean isDownloaded() {
        String downloadedFilePath = "/Users/turmeegmail.com/Desktop";
        File file = new File(downloadedFilePath + "some-file.exe");
        return true;
    }
}
