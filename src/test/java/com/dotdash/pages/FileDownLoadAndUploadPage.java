package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownLoadAndUploadPage {
    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement upload;

    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement fileUpload;

    @FindBy(xpath = "//*[contains(text(),'uploadingtest.txt')]")
    public WebElement uploadVerify;

    @FindBy(xpath = "//a[text()='some-file.txt']")
    public WebElement download;

    public FileDownLoadAndUploadPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
