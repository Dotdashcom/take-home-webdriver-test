package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends BasePage{

    public FileUploadPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "#file-upload")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement submit;

    @FindBy(xpath = "//h3[.='File Uploaded!']")
    public WebElement successMsg;
}
