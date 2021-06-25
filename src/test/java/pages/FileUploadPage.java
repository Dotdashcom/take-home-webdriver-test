package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    @FindBy(id = "file-upload")
    public WebElement chooseFileLink;

    @FindBy(id = "file-submit")
    public WebElement uploadButton;

    @FindBy(tagName = "h3")
    public WebElement uploadedMessage;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileName;


}
