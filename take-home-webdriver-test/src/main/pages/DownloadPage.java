 package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class DownloadPage extends PageObjectBase {

    @FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
    WebElement downloadLink;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public DownloadPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/download");
        return this;
    }

    public void clickDownloadLink() {
        downloadLink.click();
    }

    public Boolean isFileDownloaded(String fileName) {
        String downloadedFilePath = System.getProperty("user.dir") + File.separator + "downloadedFiles" + File.separator + fileName;
        File file = new File(downloadedFilePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(x -> file.exists());
        return file.exists();
    }
}
