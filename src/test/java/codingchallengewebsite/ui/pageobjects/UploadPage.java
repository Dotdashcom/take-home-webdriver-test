package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;
import java.time.Duration;

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
    private final UITest caller;
    private final String pageUrl;
    private final String fileName = "some-file.txt";
    private final String folder = "src/main/resources";

    public UploadPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/upload";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
    }

    public boolean isPageOpen() {
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("File Uploader"); }

    public void uploadFile() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        String pathToFile = Paths.get(this.folder, this.fileName).toAbsolutePath().toString();
        chooseFileButton.sendKeys(pathToFile);
        this.uploadButton.click();
        wait.until(ExpectedConditions.visibilityOf(successPageTitle));
    }

    public boolean validateUploadedPageTitle() {
        return successPageTitle.getText().contains("File Uploaded!"); }

    public boolean validateUploadedFileName() {
        return uploadedFile.getText().equals(fileName); }
}