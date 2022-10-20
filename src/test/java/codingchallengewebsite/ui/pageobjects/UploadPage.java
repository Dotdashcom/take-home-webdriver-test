package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class UploadPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='File Uploader']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='File Uploaded!']")
    private WebElement successPageTitle;
    @FindBy(how = How.XPATH, using = "//input[@id='file-submit']")
    private WebElement uploadButton;
    @FindBy(how = How.XPATH, using = "//input[@id='file-upload']")
    private WebElement chooseFileButton;
    @FindBy(how = How.XPATH, using = "//div[@id='drag-drop-upload']")
    private WebElement redBox;
    @FindBy(how = How.XPATH, using = "//div[@id='uploaded-files']")
    private WebElement uploadedFile;
    private UITests caller;
    private String pageUrl;
    private String fileName = "some-file.txt";
    private String folder = "src/main/resources";
    public WebDriver driver;

    public UploadPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/upload").toString();
        driver.get(this.pageUrl);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isPageOpen() {
        return this.driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("File Uploader");
    }

    public void uploadFile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String pathToFile = Paths.get(this.folder, this.fileName).toAbsolutePath().toString();
        chooseFileButton.sendKeys(pathToFile);
        this.uploadButton.click();
        wait.until(ExpectedConditions.visibilityOf(successPageTitle));
    }

    public boolean validateUploadedPageTitle() {
        return successPageTitle.getText().toString().contains("File Uploaded!");
    }

    public boolean validateUploadedFileName() {
        return uploadedFile.getText().toString().equals(fileName);
    }

}
