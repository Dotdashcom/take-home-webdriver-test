package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FileUploadPage {
    public FileUploadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "file-upload")
    public WebElement choosefile;

    @FindBy(css = "#file-submit")
    public WebElement submit;

}
