package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;


public class DownloadPage extends BasePage {

    @FindBy(css = "#content > div > a")
    private WebElement fileDownloadLink;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public void downloadFile() {
        fileDownloadLink.click();
    }

    public boolean isDownloadedFileLocated() {
        String downloadedFile = "";
        if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            downloadedFile = System.getProperty("user.home") + "\\downloads\\some-file.txt";
        } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
            downloadedFile = System.getProperty("user.home") + "/downloads/some-file.txt";
        }
        
        File file = new File(downloadedFile);
        waitUntilFileExists(file);
        return file.exists();
    }
}
