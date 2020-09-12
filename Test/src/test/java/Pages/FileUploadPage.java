package Pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class FileUploadPage extends PageBase {

    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement chooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement uploadButton;

    public  void uploadFile(){
       BrowserUtils.sendKeys(chooseFile,"/Users/aibek/Downloads/some-file.txt");
       BrowserUtils.click(uploadButton);


    }
}
