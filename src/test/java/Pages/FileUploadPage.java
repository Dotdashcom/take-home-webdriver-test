package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FileUploadPage extends BasePage{
    public FileUploadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "file-upload")
    public WebElement chooseFileLink;

    @FindBy(id = "file-submit")
    public WebElement uploadButton;

    @FindBy(tagName = "h3")
    public WebElement uploadedMessage;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileName;

}
