package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class FileUploadPage extends TestBase {

    @FindBy(id = "file-upload")
    WebElement uploadLink;
    @FindBy(id = "file-submit")
    WebElement uploadBtn;
    @FindBy(css = "div[class='example'] h3")
    WebElement uploadSuccessMessage;

    public FileUploadPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public WebElement getUploadLink() {
        return uploadLink;
    }

    public WebElement getUploadBtn() {
        return uploadBtn;
    }

    public WebElement getUploadSuccessMessage() {
        return uploadSuccessMessage;
    }

}
