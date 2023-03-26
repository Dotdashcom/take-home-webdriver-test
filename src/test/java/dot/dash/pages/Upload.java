package dot.dash.pages;

import dot.dash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upload {
    public Upload() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "file-upload")
    public WebElement chooseFileInput;
    @FindBy(id = "file-submit")
    public WebElement uploadBtn;
    @FindBy(xpath = "//h3[.='File Uploaded!']")
    public WebElement message;


}
