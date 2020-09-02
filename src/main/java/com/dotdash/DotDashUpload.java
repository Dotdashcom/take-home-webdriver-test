package com.dotdash;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static com.dotdash.DotDashWebElements.*;
import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashUpload extends BaseAPI {

    @FindBy(how = How.CSS, using = uploadButtonCss)
    public WebElement uploadButton;
    @FindBy(how = How.XPATH, using = fileUploadedMessageXp)
    public WebElement fileUploadedMessage;
    @FindBy(how = How.CSS, using = dragDropFieldCss)
    public WebElement dragDropField;
    @FindBy(how = How.CSS, using = uploadSubmitButtonCss)
    public WebElement uploadSubmitButton;
    @FindBy(how = How.CSS, using = hiddenInputCss)
    public WebElement hiddenInput;

    // Page Factory
    static DotDashUpload upload;

    public static void initPage() {
        upload = PageFactory.initElements(driver, DotDashUpload.class);
    }

    // absolute file path required
    public static String testFile = home + "/IdeaProjects/WebDriverTest/src/data/some-file.txt";

    public static void uploadFIle() {
        initPage();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Setting value for "style" attribute to make textbox visible
        js.executeScript("arguments[0].style.display='block';", upload.hiddenInput);
        // sending the file location
        upload.hiddenInput.sendKeys(testFile);
        // submitting for upload
        upload.uploadSubmitButton.click();
    }

    public static void assertFileUploaded() {
        initPage();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(upload.fileUploadedMessage));
        Assert.assertTrue(upload.fileUploadedMessage.isDisplayed());
    }

    public static void navigateToUploadPage() {
        driver.get(baseURL + "upload");
    }
}
