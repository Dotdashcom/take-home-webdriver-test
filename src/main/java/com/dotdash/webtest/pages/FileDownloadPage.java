package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(17) > a")
    protected WebElement fileDownloadButton;

    @FindBy(css = "#content > div > a:nth-child(2)")
    protected WebElement fileButton;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToFileDownloadPage() {
        fileDownloadButton.click();
    }

    public void downloadFile() {
        fileButton.click();
    }

    public boolean isFileDownloaded() {
        String path = "";
        if(System.getProperty("os.name").toUpperCase().contains("MAC")) {
            path = "/";
        } else if(System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            path = "\\";
        }
        String downloadedFileAbsPath = System.getProperty("user.home") + path + "Downloads/some-file.txt";
        File file = new File(downloadedFileAbsPath);
        return file.exists();
    }
}