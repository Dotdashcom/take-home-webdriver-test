package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

import java.io.File;

public class FileUploadPage {


    public FileUploadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(id = "file-upload")
    public WebElement chooseFileButton;


    @FindBy(id = "file-submit")
    public WebElement uploadButton;


    @FindBy(id = "uploaded-files")
    public WebElement uploadedFiles;


    public void uploadFile(String fileName){


        String filePath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + fileName;

        chooseFileButton.sendKeys(filePath);


        uploadButton.click();



    }




}
