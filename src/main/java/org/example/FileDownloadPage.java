package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class FileDownloadPage extends BasePage {

    protected WebDriver driver;

    By fileDownloadPage = By.cssSelector("[href='\\/download']");
    By fileToBeDownloaded = By.cssSelector("[href='download\\/some-file\\.txt']");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFileDownloadPage(){
        return driver.findElement(fileDownloadPage);
    }
    public WebElement getFileToBeDownloaded(){
        return driver.findElement(fileToBeDownloaded);
    }

    public String fileDownload(){

        getFileDownloadPage().click();
        getFileToBeDownloaded().click();
        String downloadPath = System.getProperty("user.home");
        System.out.println(downloadPath+"\\Downloads\\some-file.txt");
        File downloadedFile = new File(downloadPath + "\\Downloads\\some-file" );
        System.out.println(downloadedFile.exists());
        System.out.println(downloadedFile.getAbsoluteFile().exists());
        return downloadedFile.getAbsolutePath();
    }
}
