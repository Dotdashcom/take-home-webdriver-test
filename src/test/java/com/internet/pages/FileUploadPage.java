package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{

    @FindBy(id = "file-upload")
    private WebElement fileUpload;

    @FindBy(id = "file-submit")
    private WebElement submitFile;

    @FindBy(xpath = "//h3[.='File Uploaded!']")
    public WebElement message;

    public void chooseFileTobeUploaded(){
        waitforVisibilityandClickable(fileUpload);
        fileUpload.sendKeys("C:\\Users\\ilhan\\Downloads\\take-home-webdriver-test\\try.txt");
    }

    public void clickUpload(){
        waitforVisibilityandClickable(submitFile);
        submitFile.click();
    }

    public boolean ifMessageAppreared(){
        waitforVisibilityandClickable(message);
        return message.isDisplayed();
    }
}
