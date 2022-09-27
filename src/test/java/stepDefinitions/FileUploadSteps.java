package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FileUploadPage;
import utils.PropertyKeys;
import java.time.Duration;

public class FileUploadSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private FileUploadPage fileUploadPage;

    public FileUploadSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        fileUploadPage = new FileUploadPage(driver, wait);
    }

    @Given("user navigates to file upload page")
    public void navigateToFileUploadPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/upload");
        fileUploadPage.WaitUntilElementVisible(fileUploadPage.fileUploadPageHeader);
    }

    @When("user selects a file")
    public void chooseFile() {
        fileUploadPage.WaitUntilElementVisible(fileUploadPage.chooseFileButton);
        fileUploadPage.chooseFileButton.sendKeys(PropertyKeys.getProperty("download.path") + "/some-file.txt");
    }

    @And("user clicks on upload button")
    public void clickUploadButton() {
        fileUploadPage.WaitUntilElementVisible(fileUploadPage.submitFileButton);
        fileUploadPage.submitFileButton.click();
    }

    @Then("file is uploaded")
    public void uploadFile() {
        fileUploadPage.WaitUntilElementVisible(fileUploadPage.fileUploadPageHeader);
        String pageHeader = fileUploadPage.fileUploadPageHeader.getText();
        String fileName = fileUploadPage.uploadedFileName.getText();
        Assert.assertEquals(pageHeader, "File Uploaded!");
        Assert.assertEquals(fileName, "some-file.txt");
    }
}
