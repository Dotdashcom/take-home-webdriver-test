package com.assignments.pages;

import org.openqa.selenium.By;

import static com.assignments.enums.WaitStrategy.CLICKABLE;
import static com.assignments.enums.WaitStrategy.VISIBLE;
import static com.assignments.utils.JavaUtils.isFileDownloaded;

public final class FileUploadPage extends BasePage {

    private final By chooseFile = By.cssSelector("#file-upload");

    private final By submitButton = By.cssSelector("#file-submit");

    private final By fileUploadStatus = By.xpath("//h3[text()='File Uploaded!']");

    public FileUploadPage clickOnChooseFileAndUpload(String filePath) {
        sendKeys(chooseFile, filePath, CLICKABLE, "File Path");
        click(submitButton, CLICKABLE, "Upload Button");
        return this;
    }

    public boolean isFileUploaded() {
        return isDisplayed(fileUploadStatus, VISIBLE, "File Upload Status");
    }
}

