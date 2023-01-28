package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class FileUploadPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public FileUploadPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="file-upload")
    private WebElement chooseFileBtn;

    @FindBy(id="file-submit")
    private WebElement uploadBtn;

    @FindBy(tagName = "h3")
    private WebElement fileUploadedText;


    public void uploadFile(){
        navigateToUploadFilePage();
        sentKeysToUpload();
        uploadBtn.click();
        softAssert.assertTrue(fileUploadedText.isDisplayed(),"File uploaded text is not displayed");
        System.out.println(fileUploadedText.getText());
    }
    private void sentKeysToUpload(){
        String filePath = "/Users/marynagrabchuk/Downloads/some-file.txt";
        chooseFileBtn.sendKeys(filePath);
    }
    private void navigateToUploadFilePage(){
        driver.get(ConfigReader.getProperty("url")+"/upload" );
    }
}
