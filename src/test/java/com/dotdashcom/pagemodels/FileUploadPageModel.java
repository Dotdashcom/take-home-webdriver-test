package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPageModel extends PageObject {

    public static final String PAGE_URL = "/upload";

    @FindBy(id = "file-upload")
    private WebElement fileSelectElement;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilesDiv;

    public FileUploadPageModel(WebDriver driver) {
        super(driver);
    }

    public WebElement getFileSelectElement() {
        return fileSelectElement;
    }

    public WebElement getUploadButton() {
        return uploadButton;
    }

    public WebElement getUploadedFilesDiv() {
        return uploadedFilesDiv;
    }
}
