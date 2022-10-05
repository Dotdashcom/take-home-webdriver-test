package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {


    @FindBy(css = "#file-upload")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement submit;

    @FindBy(xpath = "//h3[.='File Uploaded!']")
    public WebElement successMsg;
}
