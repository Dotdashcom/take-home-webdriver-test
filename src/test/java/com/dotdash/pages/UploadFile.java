package com.dotdash.pages;

import annotations.NotVisible;
import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

@Url("/upload")
public class UploadFile extends WebPage {

    @FindBy(id = "file-upload")
    private WebElement fileUploadButton;

    @FindBy(id = "drag-drop-upload")
    private WebElement dragAndDropButton;

    @FindBy(id = "file-submit")
    private WebElement submitButton;

    @NotVisible
    @FindBy(id = "uploaded-files")
    private WebElement uploadSuccessText;

    public UploadFile uploadFileWithButton(String fileName) {
        uploadFile(fileUploadButton, fileName);
        return this;
    }

    public UploadFile uploadFileWithDragAndDrop(String fileName) {
        uploadFile(dragAndDropButton, fileName);
        return this;
    }

    public UploadFile submitFile() {
        click(submitButton);
        return this;
    }

    public String getSuccessMessage() {
        return getText(uploadSuccessText);
    }
}