package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {
    @FindBy(id="file-upload")
    WebElement chooseFile;

    @FindBy(id="file-submit")
    WebElement uploadLink;

    @FindBy(css="div[id=\"content\"] div[class=\"example\"] h3")
    WebElement uploadHeader;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void clickChooseFile(String path){
        chooseFile.sendKeys(path);
    }

    public void clickUpload(){
        uploadLink.click();
    }

    public String getHeader(){
        return uploadHeader.getText();
    }
}
