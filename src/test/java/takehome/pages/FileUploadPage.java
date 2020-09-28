package takehome.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.Driver;


public class FileUploadPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    public FileUploadPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(linkText = "File Upload")
    private WebElement fileUploadLink;
    @FindBy(id = "file-upload")
    private WebElement chooseFileButton;
    @FindBy(id = "file-submit")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@id='uploaded-files']")
    private WebElement uploadedFileName;


    public void uploadFile()    {
        String user ="Temor";
        wait.until(ExpectedConditions.elementToBeClickable(fileUploadLink));
        fileUploadLink.click();
        BrowserUtilities.wait(3);
        chooseFileButton.sendKeys("C:\\Users\\Temor\\Downloads\\some-file.txt");
        BrowserUtilities.wait(3);
        submitButton.click();


    }

    public String getText (){

    wait.until(ExpectedConditions.visibilityOf(uploadedFileName));
        return uploadedFileName.getText();


    }







}
