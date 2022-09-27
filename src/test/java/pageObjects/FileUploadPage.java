package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class FileUploadPage extends BaseClass {

    public FileUploadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div['Example']/h3")
    public WebElement fileUploadPageHeader;

    @FindBy(id = "file-upload")
    public WebElement chooseFileButton;

    @FindBy(id = "file-submit")
    public WebElement submitFileButton;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileName;
}
