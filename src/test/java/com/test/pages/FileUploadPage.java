package com.test.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.util.Config;

public class FileUploadPage {

    private WebDriver driver;
    private By uploadInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("fileupload"));
    }

    public void uploadFile(String filePath) {
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(new File(filePath).getAbsolutePath());
        
        // Click the upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
