package pages;

import org.openqa.selenium.*;
import java.io.File;

public class FileUploadPage extends BasePage {
    private String path = "/upload";

    private By fileUploadInputBy = By.xpath("//input[@id='file-upload']");
    private By uploadButtonBy = By.xpath("//input[@id='file-submit']");
    private By dragDropUploadBy = By.xpath("//div[@id='drag-drop-upload']");
    private By uploadConfirmBy = By.xpath("//div[@id='uploaded-files']");
    private By secretDropzoneInputBy = By.xpath("//input[@type='file' and @class='dz-hidden-input']");
    private By dragDropUploadedBy = By.xpath("//div[@class='dz-filename']");
    private String uploadPath = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "test" + File.separator + "TestFiles";
    private String uploadFileName = "some-file.txt";

    public FileUploadPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void addFileToInput() {
        driver.findElement(fileUploadInputBy).sendKeys(uploadPath + File.separator + uploadFileName);
    }

    public void clickSubmitButton() {
        driver.findElement(uploadButtonBy).click();
    }

    public void addFileToDragDrop() {
        WebElement dragDropUpload = driver.findElement(secretDropzoneInputBy);
        dragDropUpload.sendKeys(uploadPath + File.separator + uploadFileName);
    }

    public boolean verifyUpload() {
        return driver.findElement(uploadConfirmBy).getText().equals(uploadFileName);
    }

    public boolean verifyDragDropUpload() {
        return driver.findElement(dragDropUploadedBy).getText().equals(uploadFileName);
    }
}
