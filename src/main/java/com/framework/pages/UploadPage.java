package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadPage extends PageObjectBase {
    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement chooseFileButton;

    @FindBy(xpath = "//div[@id='drag-drop-upload']")
    WebElement dragAndDropField;

    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement uploadButton;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    WebElement uploadedFileField;

    @FindBy(xpath = "//div[@id='drag-drop-upload']/descendant::div[@class='dz-filename']/span")
    WebElement dragAndDropFieldFileName;

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public UploadPage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL") + "/upload");
        return this;
    }

    public String uploadFileUsingButton(String fileName) {
        String filePath = System.getProperty("user.dir") + File.separator + "downloadedFiles" + File.separator + fileName;
        chooseFileButton.sendKeys(filePath);
        uploadButton.click();
        return uploadedFileField.getText();
    }

    public String uploadFileUsingDragAndDrop(String fileName) {
        String filePath = System.getProperty("user.dir") + File.separator + "downloadedFiles" + File.separator + fileName;
        Utils.DropFile(driver, new File(filePath), dragAndDropField, 0, 0);
        return dragAndDropField.getText();
    }

}
