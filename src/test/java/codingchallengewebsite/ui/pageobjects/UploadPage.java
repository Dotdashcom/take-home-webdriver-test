package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class UploadPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='File Uploader']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Elemental Selenium']")
    public WebElement pageFooterLink;
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='File Uploaded!']")
    public WebElement successPageTitle;
    @FindBy(how = How.XPATH, using = "//input[@id='file-submit']")
    public WebElement uploadButton;
    @FindBy(how = How.XPATH, using = "//input[@id='file-upload']")
    public WebElement chooseFileButton;
    @FindBy(how = How.XPATH, using = "//div[@id='drag-drop-upload']")
    public WebElement redBox;
    @FindBy(how = How.XPATH, using = "//div[@id='uploaded-files']")
    public WebElement uploadedFile;
    private final UITest caller;
    private final String pageUrl;
    private final String fileName = "some-file.txt";

    public UploadPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/upload";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle), visibilityOf(this.pageFooterLink)));
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void uploadFile() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        String folder = "src/test/resources";
        String pathToFile = Paths.get(folder, this.fileName).toAbsolutePath().toString();
        chooseFileButton.sendKeys(pathToFile);
        this.uploadButton.click();
        wait.until(ExpectedConditions.visibilityOf(successPageTitle));
    }

    public Boolean validateUploadedPageTitle() {
        return successPageTitle.getText().contains("File Uploaded!"); }

    public Boolean validateUploadedFileName() {
        return uploadedFile.getText().equals(fileName); }
}