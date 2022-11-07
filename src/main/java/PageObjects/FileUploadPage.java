package PageObjects;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FileUploadPage {
    public WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "file-upload")
    private WebElement pickFile;

    @FindBy(id = "file-submit")
    private WebElement uploadfile;

    @FindBy(id = "uploaded-files")
    private List< WebElement> uploadedfiles;






    public void uploadDocument(String file){
        Helpers.SendText(pickFile,file);

    }
    public void clickUpload(){
        Helpers.ClickElement(uploadfile);
    }

    public boolean validateFileUpload(String file) throws InterruptedException {

       return Helpers.SearchElementValueList(uploadedfiles,file.split("\\\\")[file.split("\\\\").length-1]);
    }


}

