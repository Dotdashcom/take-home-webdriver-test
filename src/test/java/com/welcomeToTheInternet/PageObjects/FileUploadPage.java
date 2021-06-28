package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadPage {

    WebDriver localDriver;
    public FileUploadPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/upload']")
    @CacheLookup
    WebElement linkUploadPage;

    @FindBy(id = "file-upload")
    @CacheLookup
    WebElement chooseFileField;


    @FindBy(id = "file-submit")
    @CacheLookup
    WebElement uploadButton;

    @FindBy(xpath = "//h3[contains(text(),'File Uploaded!')]")
    @CacheLookup
    WebElement successMessage;

    public void clickUploadPageLink() {
        linkUploadPage.click();
    }

    public void setUploadPath() {
        chooseFileField.sendKeys("/Users/alexeysolovyev/Downloads/some-file.txt");
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public void waitForMessage() {
        WebDriverWait wait = new WebDriverWait(localDriver, 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'File Uploaded!')]")));
        boolean isVisible = element1.isDisplayed();
        if (isVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }




}
