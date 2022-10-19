package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{

    @FindBy (id = "file-upload")
    public WebElement chooseFile;

    @FindBy (id = "file-submit")
    public WebElement uploadBtn;

    @FindBy (id = "drag-drop-upload")
    public WebElement dragAndDrop;

    @FindBy (tagName = "h3")
    public WebElement message;

    @FindBy (id = "uploaded-files")
    public WebElement uploadedFiles;

}
