package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FileDownloadPage {
    public FileDownloadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "some-file.txt")
    public WebElement file;
}
