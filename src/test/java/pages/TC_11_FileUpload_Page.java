package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_11_FileUpload_Page {
    public TC_11_FileUpload_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText ="File Upload")
    public WebElement fileUploadlink;

    @FindBy(id="file-upload")
    public WebElement chooseFileButton;

    @FindBy(id="file-submit")
    public WebElement uploadButton;

    @FindBy(xpath ="//*[(text()='File Uploaded!')]")
    public WebElement fileUploadedMessage;


}
