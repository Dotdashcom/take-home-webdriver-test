package Main;

import Utilities.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadUploadPage {

    @FindBy(xpath = "//a[.='some-file.txt']")
    public WebElement TextFile;

    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement UploadButton;

    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFileButton;

    @FindBy(tagName = "h3")
    public WebElement fileUploadedText;

    public FileDownloadUploadPage(){
        PageFactory.initElements(DriverHelper.getDriver(),this);
    }




}
