package pages;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class FileUploadPage extends PageBase{
    @FindBy(xpath = "//*[@class='button']")
    protected WebElement uploadButton;

    @FindBy(xpath = "//*[@id='file-upload']")
    protected WebElement fileUpload;

    @FindBy(xpath = "//*[@class='example']/h3")
    protected WebElement message;

    String path = "/Users/user/Downloads/some-file.txt";

    public void uploadFile(){
        fileUpload.sendKeys(path);
        BrowserUtils.wait(2);
        uploadButton.click();
        BrowserUtils.waitForVisibility(message,5);
        Assert.assertEquals("File Uploaded!",message.getText());
    }}
