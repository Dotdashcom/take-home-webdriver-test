package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUploadPage extends BasePage{

    protected WebDriver driver;

    By fileUploadPage = By.cssSelector("[href='\\/upload']");
    By chooseFileButton = By.cssSelector("input#file-upload");
    By uploadButton = By.cssSelector("[type='submit']");
    By fileUploadedMessage = By.xpath("//div[@id='content']//h3[.='File Uploaded!']");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getFileUploadPage(){
        return driver.findElement(fileUploadPage);
    }
    public WebElement getchooseFileButton(){
        return driver.findElement(chooseFileButton);
    }
    public WebElement getUploadButton(){
        return driver.findElement(uploadButton);
    }
    public WebElement getFileUploadedMessage(){ return driver.findElement(fileUploadedMessage);}

    public void uploadFile(){
        getFileUploadPage().click();
        String filePath = new File("uploadtestfile.txt").getAbsolutePath();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(getchooseFileButton()));
        getchooseFileButton().sendKeys(filePath);
        wait.until(ExpectedConditions.elementToBeClickable(getUploadButton()));
        getUploadButton().click();
        wait.until(ExpectedConditions.visibilityOf(getFileUploadedMessage()));
    }
}
