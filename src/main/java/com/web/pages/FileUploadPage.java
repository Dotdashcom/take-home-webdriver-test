package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;

public class FileUploadPage extends TestBase{
    @FindBy(xpath="//input[@class='button']")
    WebElement uploadBtn;

    @FindBy(id="file-upload")
    WebElement chooseFileBtn;

    @FindBy(id="uploaded-files")
    WebElement uploadedFile;


    public FileUploadPage(){

        PageFactory.initElements(driver, this);
    }

    public void clickUpload(){
        uploadBtn.click();
    }

    public void clickChooseFileBtn(){
        chooseFileBtn.sendKeys("C:\\Users\\rezas\\Downloads\\ToUpload.txt");
    }

    public String verifyFileUpload(){
        return uploadedFile.getText();
    }
}
