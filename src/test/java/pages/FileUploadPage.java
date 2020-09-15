package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class FileUploadPage extends PageBase {

    @FindBy(xpath = "//*[@class='button']")
    protected WebElement uploadButton;

    @FindBy(xpath = "//*[@id='file-upload']")
    protected WebElement fileUpload;

    String path = "/Users/user/Downloads/some-file.txt";

    public void uploadFile(){
        fileUpload.sendKeys(path);
        BrowserUtils.wait(2);
        uploadButton.click();
    }

}
