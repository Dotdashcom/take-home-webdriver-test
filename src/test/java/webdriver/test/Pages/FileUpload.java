package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;

import java.io.File;

import static org.testng.Assert.assertTrue;


public class FileUpload {

    //local webdriver variable
    private WebDriver driver;


    @FindBy(id="file-upload")
    private WebElement fileUploadLink;

    @FindBy(id="file-submit")
    private WebElement uploadButton;

    @FindBy(xpath = "//h3")
    public WebElement fileUploadedMessage;

    //Page Class Constructor
    public FileUpload(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void uploadFileAndClickButton(String file) {


        fileUploadLink.sendKeys(file);

        uploadButton.click();
    }



    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/upload");
    }
}
