package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadPage extends BasePage{
    public FileUploadPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'File Uploader')]")
    public WebElement fileUploadPageHeader;

    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement fileUploadPageUpload;
    @FindBy(xpath = "//input[contains(@value,'Upload')]")
    public WebElement fileUploadPageUploadSubmit;
    @FindBy(xpath = "//h3[contains(.,'File Uploaded!')]")
    public WebElement fileUploadPageUploadSuccess;

    public Boolean validatePageLanding(){
        fileUploadPageHeader.isDisplayed();
        fileUploadPageUpload.isDisplayed();
        return true;
    }

    public void uploadFile(){
        fileUploadPageUpload.sendKeys("C:\\Users\\speed\\Downloads\\some-file.txt");
        fileUploadPageUploadSubmit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(fileUploadPageUploadSuccess));
    }

    public Boolean uploadSuccess(){
        fileUploadPageUploadSuccess.isDisplayed();
        return true;
    }
}
