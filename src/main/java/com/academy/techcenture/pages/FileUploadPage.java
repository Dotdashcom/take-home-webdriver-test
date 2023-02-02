package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement choseFileBtn;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement uploadBtn;

    @FindBy (xpath = "//h3[normalize-space()='File Uploaded!']")
    private WebElement fileUploadedMsg;

    @FindBy (xpath = "//div[@id='uploaded-files']")
    private WebElement uploadedFile;

    public void verifyUploadFile() throws InterruptedException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/UploadingFile.txt");
        choseFileBtn.sendKeys(file.getAbsolutePath());
        Thread.sleep(1000);
        btnClick(uploadBtn);
        Thread.sleep(1000);
        softAssert.assertEquals(fileUploadedMsg.getText().trim(),"File Uploaded!", "File uploaded message is not match");
        softAssert.assertEquals(uploadedFile.getText(),file.getName(), "Uploaded file and name of file is not match");
    }

}
