package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    public WebElement chooseFileButton;

    @FindBy(xpath = "//h3")
    public WebElement message;

    @FindBy(id = "file-submit")
    public WebElement uploadButton;

    public void uploadFile(String filePath) {
        chooseFileButton.sendKeys(filePath);
    }
}
