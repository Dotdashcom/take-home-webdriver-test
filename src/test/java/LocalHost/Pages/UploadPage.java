package LocalHost.Pages;

import LocalHost.Utilities.BrowserUtils;
import LocalHost.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UploadPage {
    public  UploadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "file-upload")
    private WebElement uploadButton;

    @FindBy(id = "file-submit")
    private WebElement submit;

    @FindBy(id="uploaded-files")
    private WebElement finish;

    public void UploadFile(){
        // This will fail unless changed to local pc's file path. This is my location of the file
        uploadButton.sendKeys("C:/Users/erago/Downloads/some-file.txt");
        submit.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(finish.isDisplayed());
    }
}
