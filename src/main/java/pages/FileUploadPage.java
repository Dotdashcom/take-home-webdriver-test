package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    @FindBy(id = "file-submit")
    protected WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    protected WebElement uploadedFileName;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile() {
        mouseActionsClickOnElement("#file-upload");
        pauseInSeconds(1);
        fileUploadRobotClass();
        pauseInSeconds(2);
        uploadButton.click();
    }

    public String getUploadedFileName() {
        return uploadedFileName.getText();
    }
}