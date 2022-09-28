package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;


public class FileUploadPage extends BasePage {

    @FindBy(id = "file-upload")
    private WebElement inputField;

    @FindBy(id = "file-submit")
    private WebElement uploadBtn;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String name){
        String uploadFile = System.getProperty("user.home") + "\\downloads\\" + name;
        File file = new File(uploadFile);

        inputField.sendKeys(uploadFile);
        uploadBtn.click();
    }

    public String getUploadedFileName(){
        return uploadedFiles.getText();
    }
}