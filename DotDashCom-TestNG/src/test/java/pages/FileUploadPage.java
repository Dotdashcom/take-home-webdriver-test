package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FileUploadPage {
    public FileUploadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "file-upload")
    public WebElement chooseFileLink;

    @FindBy(id = "file-submit")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[@id='content']/div/h3")
    public WebElement uploadedMessage;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileName;
}
