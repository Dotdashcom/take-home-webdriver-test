package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FileUploadPage {
    public FileUploadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='example']/h3")
    public WebElement header;

    @FindBy(id = "file-upload")
    public WebElement chooseFileBtn;

}

