package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    @FindBy (id = "file-upload")
    public WebElement fileUploadInput;

    @FindBy (id = "file-submit")
    public WebElement uploadButton;

    @FindBy (xpath = "//*[text()='File Uploaded!']")
    public WebElement fileUploadedHeader;
}
