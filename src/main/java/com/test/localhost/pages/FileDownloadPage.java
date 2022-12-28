package com.test.localhost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FileDownloadPage {

    public FileDownloadPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "File Download")
    WebElement fileDownloadButton;

    @FindBy(linkText = "some-file.txt")
    WebElement fileButton;

    public void clickButton(){
        fileDownloadButton.click();
    }
    public void downloadButton(){
        fileButton.click();
    }
}
