package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    @FindBy( how = How.CSS , using = "#file-upload")
    WebElement chooseFileButton;

    @FindBy( how = How.CSS , using = "#file-submit")
    WebElement submitButton;

    @FindBy( how = How.CSS , using = "div[class='example'] h3")
    WebElement fileUploadStatus;

    public FileUploadPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void uploadFile(String filePath){
           chooseFileButton.sendKeys(filePath);
           submitButton.click();
    }

    public String fileUploadStatusText(){
        return fileUploadStatus.getText();
    }
}
