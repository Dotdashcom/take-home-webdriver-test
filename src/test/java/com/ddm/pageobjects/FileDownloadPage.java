package com.ddm.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


public class FileDownloadPage extends WebPage {

    @FindBy(css = "#content > div > a:nth-child(2)")
    WebElement fileDownloadLink;

    public FileDownloadPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    private String getDownloadedFileAbsPath() {
        String pathSeparator = "";
        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            pathSeparator = "\\";
        } else if(System.getProperty("os.name").toLowerCase().contains("mac")) {
            pathSeparator = "/";
        }

        String downloadsDir = System.getProperty("user.home") + pathSeparator + "Downloads/";
        String downloadedFileName = "some-file.txt";
        String fileAbsPath = downloadsDir + downloadedFileName;

        System.out.println("Path : " + fileAbsPath);
        return fileAbsPath;
    }

    public void downloadFile() {
        fileDownloadLink.click();

        File downloadedFile = new File(getDownloadedFileAbsPath());
        FluentWait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250));
        try {
            driverWait.until( isTrue -> downloadedFile.exists() == true);
        } catch (WebDriverException e) {
            System.out.println("Driver exception occured." + e.getMessage());
        }
    }

    public boolean isFileDownloaded() {
        File downloadedFileObj = new File(getDownloadedFileAbsPath());
        return downloadedFileObj.exists();
    }
}
