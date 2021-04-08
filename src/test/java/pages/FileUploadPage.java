package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class FileUploadPage {
    public FileUploadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "file-upload")
    public WebElement chooseFileBtn;

    @FindBy(xpath = "//h3[contains(text(),'File Uploaded!')]")
    public WebElement confirmMsg;

    @FindBy(id ="file-submit")
    public WebElement uploadBtn;

}
