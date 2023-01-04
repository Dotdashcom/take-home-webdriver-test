package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPage extends Page {
    private static final By CHOOSE_FILE_BUTTON = By.id("file-upload");
    private static final By UPLOAD_BUTTON = By.id("file-submit");
    private static final By UPLOADED_FILE_PANEL = By.id("uploaded-files");

    public FileUploadPage(ChromeDriver driver) {
        super(driver);
    }

    public FileUploadPage enterFilePath(String filePath) {
        visibilityOfElementLocated(CHOOSE_FILE_BUTTON, BasePage.TIMEOUT).sendKeys(filePath);
        return this;
    }

    public FileUploadPage clickUploadButton() {
        click(UPLOAD_BUTTON, BasePage.TIMEOUT);
        return this;
    }

    public String getUploadedFilePanelText() {
        return visibilityOfElementLocated(UPLOADED_FILE_PANEL, BasePage.TIMEOUT).getText();
    }
}
