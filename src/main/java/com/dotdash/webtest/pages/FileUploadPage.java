package com.dotdash.webtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(18) > a")
    protected WebElement fileUploadButton;

    @FindBy(id = "file-upload")
    protected WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    protected WebElement uploadButton;

    public FileUploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToFileUploadPage() {
        fileUploadButton.click();
    }

    public void uploadFile() {
        chooseFileButton.sendKeys(fileToUpload());
        uploadButton.click();
    }

    public String fileToUpload() {
        String fileName = "";
        if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
            fileName = System.getProperty("user.home") + "/Downloads/some-file.txt";
        } else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            fileName = System.getProperty("user.home") + "\\Downloads\\some-file.txt";
        }
        System.out.println("Uploading file name: " + fileName);
        return fileName;
    }

    public boolean isFileUploaded() {
       waitForVisibilityOfElement("#content > div > h3");
       WebElement uploadedFile = driver.findElement(By.cssSelector("#uploaded-files"));
       return uploadedFile.getText().equals("some-file.txt");
    }
}
