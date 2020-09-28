package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class UploadPage extends BasePage {

    @FindBy(id = "file-upload")
    private WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(id = "drag-drop-upload")
    private WebElement dragDropUploadArea;

    @FindBy(xpath = "//h3[contains(text(), 'File Uploaded')]")
    private WebElement uploadedMessage;

    public UploadPage(WebDriver driver) {
        super(driver, EndPointPath.UPLOAD);

    }

    public void uploadFile(String filePath) {
        chooseFileButton.sendKeys(filePath);
        uploadButton.click();
    }

    public boolean verifyUploadSuccessfully() {
        return uploadedMessage.isDisplayed();
    }

    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }


}
