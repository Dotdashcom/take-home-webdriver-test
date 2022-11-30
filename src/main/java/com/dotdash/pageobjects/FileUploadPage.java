package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FileUploadPage extends BasePage {

    @FindBy(how = How.CSS, using = "#file-upload")
    private WebElement fileChooser;

    @FindBy(how = How.CSS, using = "#file-submit")
    private WebElement uploadButton;

    @FindBy(how = How.CSS, using = "#uploaded-files")
    private WebElement uploadedFiles;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public FileUploadPage goToFileUploadPage() {
        driver.get(BASEURL + "/upload");
        return this;
    }

    public FileUploadPage uploadFile(String path) {
        waitForVisibilityOf(fileChooser).sendKeys(path);
        waitForClickabilityOf(uploadButton).click();
        return this;
    }

    public String getUploadSuccessMessage() {
        return waitForVisibilityOf(uploadedFiles).getText();
    }
}
