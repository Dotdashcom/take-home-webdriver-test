package resources.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import resources.utilities.BaseClass;

public class FileUploadPages extends BaseClass {

    public FileUploadPages() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input#file-upload")
    WebElement chooseFile;

    @FindBy(css="input#file-submit")
    WebElement upload;

    @FindBy(css="div.example>h3")
    WebElement fileUploadTxt;


    public void userfileupload() {
        chooseFile.sendKeys(prop.getProperty("fileuploadpath"));
        upload.click();
    }

    public void userverifyFileUpload() {
        String fileUpload=fileUploadTxt.getText();
        String propfileText=prop.getProperty("fileuploadMsg");
        Assert.assertEquals(fileUpload,propfileText.trim());
    }
}
