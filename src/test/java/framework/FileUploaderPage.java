package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploaderPage extends BasePage{

    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement fileUploadLink;

    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement fileUploadButton;

    @FindBy(xpath = "//h3[contains(text(), 'File Uploaded!')]")
    WebElement uploadSuccessMessage;

    public FileUploaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void testFileUploader(WebDriver driver, String filePath) {
        setValue(driver, fileUploadLink, filePath);
        clickOnElement(driver, fileUploadButton, "Success: Clicked on Upload button",
                "Failed: Unable to click on Upload button");
    }

    public boolean isUploadSuccess (WebDriver driver) {
        if (isElementPresent(driver, uploadSuccessMessage)){
            return true;
        }
        return false;
    }
}
