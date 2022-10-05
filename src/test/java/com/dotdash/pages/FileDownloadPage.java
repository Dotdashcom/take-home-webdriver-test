package com.dotdash.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileDownloadPage extends BasePage{


    @FindBy(linkText = "some-file.txt")
    public WebElement txtFile;
    public static boolean file_exist(String filePath) {
        boolean isFilePresent = false;

        File file = new File(filePath);

        if (file.exists()) {
            isFilePresent = true;
        } else {
            isFilePresent = false;
        }
        return isFilePresent;
    }

}
