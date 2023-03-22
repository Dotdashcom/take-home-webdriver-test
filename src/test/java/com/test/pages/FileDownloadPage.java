package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

import java.io.File;

public class FileDownloadPage {

    private WebDriver driver;
    private By fileLink = By.linkText("some-file.txt");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("filedownload"));
    }

    public void clickFileLink() {
        driver.findElement(fileLink).click();
    }

    public boolean isFileDownloaded() {
        File file = new File("src/test/resources/some-file.txt");
        int timeout = 0;
        while (!file.exists()) {
            try {
                Thread.sleep(1000);
                timeout++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (timeout > 10) {
                return false;
            }
        }
        return file.exists();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
