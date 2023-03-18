package com.hired.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileUploadPage {
    public WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="file-upload")
    private WebElement chooseFile;

    @FindBy(id="file-submit")
    private WebElement upload;

    public void uploadFile()  {
        chooseFile.sendKeys("C:\\Users\\ablik\\IdeaProjects\\bawudong\\runOnUnix.txt");
        upload.click();
        Assert.assertTrue((driver.findElements(By.id("uploaded-files"))).size()>0);
    }
}
