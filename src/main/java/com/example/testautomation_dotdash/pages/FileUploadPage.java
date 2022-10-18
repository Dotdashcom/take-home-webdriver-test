package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver){

        super(driver);
        driver.get(prop.getProperty("baseurl") + "/upload");
    }

    @FindBy(id = "file-upload")
    private WebElement chooseFileBtn;

    @FindBy(id = "drag-drop-upload")
    private WebElement dragDropFileBox;

    @FindBy(id = "file-submit")
    private WebElement uploadBtn;


    public void chooseFileToUpload(String filePath){

        chooseFileBtn.sendKeys(filePath);

    }

    public void clickUploadButton(){
        uploadBtn.click();
    }


    public void assertFileWasUploaded(){
        WebElement fileUploadedText = driver.findElement(By.cssSelector("div[class='example'] h3"));
        Assert.assertEquals("File Uploaded!", fileUploadedText.getText());

        WebElement fileUploadedName = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals("upload-file.txt", fileUploadedName.getText());

    }

}
