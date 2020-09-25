package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class fileUploadPage extends basePage{

    @FindBy(id = "file-upload")
    public WebElement chooseFile;

    @FindBy(id = "file-submit")
    public WebElement upload;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFile;


}
