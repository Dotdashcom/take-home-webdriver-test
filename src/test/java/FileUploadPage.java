import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileUploadPage extends PageObject{

    @FindBy(id = "file-submit")
    public WebElement upload_button;
    @FindBy(id = "file-upload")
    public WebElement choosefile_button;
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    public void UploadFile()
    {
        choosefile_button.sendKeys("C:\\Users\\Sushmitha Sajeev\\Downloads\\some-file.txt");

        upload_button.click();

        WebElement File_uploaded = driver.findElement(By.xpath("//h3"));
        String isUploadedText = File_uploaded.getText();

        Assert.assertEquals(isUploadedText,"File Uploaded!");

    }
}
