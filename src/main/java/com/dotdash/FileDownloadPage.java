package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileDownloadPage extends Util {

    protected WebDriver driver;
    
    // selectors
    private By fileDownloadPageLink = By.cssSelector("[href='\\/download']");
    private By fileLink = By.cssSelector("[href='download\\/some-file\\.txt']");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getFileDownloadPage(){
        driver.findElement(fileDownloadPageLink).click();
    }
    
    public void getFileToBeDownloaded(){
        driver.findElement(fileLink).click();
    }

    public String fileDownload(){

        getFileDownloadPage();
        getFileToBeDownloaded();
        String downloadPath = prop.getProperty("downloadpath");
        System.out.println(downloadPath+"\\Downloads\\some-file.txt");
        File downloadedFile = new File(prop.getProperty("filePath") );
        System.out.println(downloadedFile.exists());
        System.out.println(downloadedFile.getAbsoluteFile().exists());
        return downloadedFile.getAbsolutePath();
    }
}