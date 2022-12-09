package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FileUploadPage {

    public FileUploadPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "File Upload")
    WebElement fileUploadButton;

    @FindBy(id = "file-upload")
    WebElement chooseButton;
    @FindBy(id = "file-submit")
    WebElement uploadButton;
    @FindBy(tagName = "h3")
    WebElement message;

    public void clickFileUpload(){
        fileUploadButton.click();
    }
    public void clickChooseButton(String file){
        chooseButton.sendKeys(file);
    }
    public void clickUploadButton(){
        uploadButton.click();
    }
    public String getText(){
        return BrowserUtils.getText(message);
    }
}
