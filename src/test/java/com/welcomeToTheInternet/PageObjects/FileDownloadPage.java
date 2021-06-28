package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.File;
import java.util.Objects;


public class FileDownloadPage {

    WebDriver localDriver;
    public FileDownloadPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    private static final String downloadPath = "/Users/alexeysolovyev/Downloads";

    @FindBy(css = "a[href='/download']")
    @CacheLookup
    WebElement linkDownloadPage;

    @FindBy(xpath = "//*[@id='content']/div/a")
    @CacheLookup
    WebElement linkFileDownload;

    public void clickDownloadPageLink() {
        linkDownloadPage.click();
    }

        boolean isFileDownloaded() {
        boolean flag = false;
        File dir = new File(FileDownloadPage.downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dirContents).length; i++) {
            if (dirContents[i].getName().equals("some-file.txt")) {
                return flag = true;
            }
        } return flag;
    }

    public void clickDownloadFileLink() throws InterruptedException {
        linkFileDownload.click();
        Thread.sleep(500);
        Assert.assertTrue(isFileDownloaded(), "Failed to download file.");
    }
}
