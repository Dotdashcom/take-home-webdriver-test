package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/upload
public class FileUploadPage {
    @FindBy(xpath = "//*[@id='file-upload']")
    public WebElement inputFileUpload;

    @FindBy(id = "file-submit")
    public WebElement inputFileSubmit;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    public WebElement msgFileUploaded;



    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
