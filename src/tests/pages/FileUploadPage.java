package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;

public class FileUploadPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"file-upload\"]")
    public WebElement buttom_FileUpload;

    @FindBy(xpath = "//*[@id=\"uploaded-files\"]]")
    public WebElement uploaded_files;


    public FileUploadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void verifyFileUpload() {
        buttom_FileUpload.sendKeys("/Users/Downloads/sample-file.txt");
        if(uploaded_files.isDisplayed())
            Assert.assertTrue(uploaded_files.getAttribute("text").equalsIgnoreCase("sample-file.txt"),"File not uploaded  as expected");
        else
            Reporter.log("File not uploaded");

    }

}


