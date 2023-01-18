package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import com.qa.take_home_webdriver_test.constants.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FileUploadPage extends BasePage {

    // PAGE INITIALIZATION:
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CHOOSE_FILE = By.id("file-upload");
    private static final By UPLOAD = By.id("file-submit");
    private static final By FILE_UPLOADED = By.cssSelector("div[class='example'] h3");

    // WEB ELEMENTS:
    private WebElement getChooseFile() {
        wait.until(ExpectedConditions.elementToBeClickable(CHOOSE_FILE));
        return driver.findElement(CHOOSE_FILE);
    }

    private WebElement getUploadBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(UPLOAD));
        return driver.findElement(UPLOAD);
    }

    private WebElement getFileUploadedMsg() {
        wait.until(ExpectedConditions.elementToBeClickable(FILE_UPLOADED));
        return driver.findElement(FILE_UPLOADED);
    }

    // METHODS:
    public void fileUpload() {
        log.debug("User click on the 'Choose file' button for uploading file. ");
        getChooseFile().sendKeys(Paths.UPLOAD_FILE_PATH);
        log.info("User clicks on the 'Upload' button. ");
        getUploadBtn().click();
    }

    public boolean isUploadedMsgDisplayed(String message) {
        try {
            log.info("User can see '" + message + "'. ");
            System.out.println(" =====> " + getFileUploadedMsg().getText() + " <===== ");
            return getFileUploadedMsg().isDisplayed() && getFileUploadedMsg().getText().equals(message);
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }
}


