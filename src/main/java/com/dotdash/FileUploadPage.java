package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUploadPage extends Util{

    protected WebDriver driver;

    private By fileUploadPageLink = By.cssSelector("[href='\\/upload']");
    private By chooseFileButton = By.cssSelector("input#file-upload");
    private By uploadButton = By.cssSelector("[type='submit']");
    private By fileUploadedMessage = By.xpath("//div[@id='content']//h3[.='File Uploaded!']");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }
    public void openFileUploadPage(){
         driver.findElement(fileUploadPageLink).click();
    }
    public WebElement getchooseFileButton(){
        return driver.findElement(chooseFileButton);
    }
    public WebElement getUploadButton(){
        return driver.findElement(uploadButton);
    }
    public WebElement getFileUploadedMessage() { 
    	return driver.findElement(fileUploadedMessage);
    }

    public void uploadFile(){
        String filePath = new File(prop.getProperty("uploadfile")).getAbsolutePath();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(getchooseFileButton()));
        getchooseFileButton().sendKeys(filePath);
        wait.until(ExpectedConditions.elementToBeClickable(getUploadButton()));
        getUploadButton().click();
        wait.until(ExpectedConditions.visibilityOf(getFileUploadedMessage()));
    }
}