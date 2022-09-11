package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileUpload {

    public FileUpload(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "File Upload")
    WebElement fileUpload;

    @FindBy(id = "file-upload")
    WebElement fileChoose;

    @FindBy(className = "button")
    WebElement uploadButton;

    @FindBy(id = "file-submit")
    WebElement submitButton;

    @FindBy(xpath = "//h3")
    WebElement message;

    public void uploadFile(String filePath){
        fileUpload.click();
        fileChoose.sendKeys(filePath);
        submitButton.click();
        Assert.assertEquals(message.getText(),"File Uploaded!");


    }
}
