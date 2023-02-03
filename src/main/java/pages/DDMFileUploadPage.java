package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DDMFileUploadPage extends DDMBasePage  {

    @FindBy(css = "[id='file-upload']")
    protected WebElement fileNameToUpload;

    @FindBy(css = "[id='file-submit']")
    protected WebElement uploadButton;

    @FindBy(css = "[id='uploaded-files']")
    protected WebElement uploadedFileName;

    public DDMFileUploadPage(WebDriver driver)  {
        super(driver);
    }

    public void uploadFile()  {
        String uploadFileName = "";
        if(System.getProperty("os.name").toLowerCase().contains("windows")) {
            uploadFileName = System.getProperty("user.dir") + "\\test-files\\automation.jpg";
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            uploadFileName = System.getProperty("user.dir") + "/test-files/automation.jpg";
        }
        fileNameToUpload.sendKeys(uploadFileName);
        uploadButton.click();
    }

    public String uploadedFileName()  {
        return uploadedFileName.getText();
    }
}