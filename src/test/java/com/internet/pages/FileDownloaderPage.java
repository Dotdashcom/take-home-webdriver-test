package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileDownloaderPage extends BasePage{

    @FindBy(xpath = "//a[.='some-file.txt']")
    private WebElement downloadFile;



    public void clickDownloadFile(){
        waitforVisibilityandClickable(downloadFile);
        downloadFile.click();
    }

    public boolean checkFile(String fileName) {
        String home = System.getProperty("user.home");
        String downloadFilepath = home + "/Downloads/";
        File dir = new File(downloadFilepath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                return true;
            }
        }
        return false;
    }

}
