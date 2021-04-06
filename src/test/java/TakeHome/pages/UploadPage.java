package TakeHome.pages;

import TakeHome.utilities.BrowserUtils;
import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage extends BasePage {

    public  UploadPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "file-upload")
    private WebElement uploadButton;

    @FindBy(id = "file-submit")
    private WebElement submit;

    @FindBy(id="uploaded-files")
    private WebElement finish;

    @FindBy(className="example")
    private WebElement uploadMessage;


    public void uploadFile(){
        // This will fail unless changed to local pc's file path. This is my location of the file
        uploadButton.sendKeys("C:/Users/mysah/IdeaProjects/take-home-webdriver-test1/src/test/java/TakeHome/Group29.txt");
        submit.click();
        BrowserUtils.waitFor(3);
    }

    public String getUploadSuccessMessage () {
        finish.isDisplayed();
        return uploadMessage.getText();
    }

}
