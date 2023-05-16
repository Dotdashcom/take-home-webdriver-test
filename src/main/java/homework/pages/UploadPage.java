package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadPage {

    public UploadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFileButton;


    @FindBy(id = "file-submit")
    public WebElement uploadButton;


    @FindBy(id = "uploaded-files")
    public WebElement uploadedFiles;



}
