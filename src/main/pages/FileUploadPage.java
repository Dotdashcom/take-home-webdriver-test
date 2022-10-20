package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileUploadPage extends BasePage {
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    private WebElement inputField;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;

    public void uploadFile(String name){
        String  uploadFile = System.getProperty("user.home") + "\\downloads\\" + name;
         File file = new File(uploadFile);
        inputField.sendKeys(uploadFile);
        uploadButton.click();
    }

    public String getUploadedFileName(){
        return uploadedFiles.getText();
    }
}
