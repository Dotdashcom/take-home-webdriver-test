package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DownloadPage;
import utils.PropertyKeys;

import java.io.File;
import java.time.Duration;

public class DownloadSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private DownloadPage downloadPage;

    public DownloadSteps() {
        String timeout = PropertyKeys.getProperty("timeout");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
        downloadPage = new DownloadPage(driver, wait);
    }

    @Given("user navigates to download page")
    public void navigateToDownloadPage() {
        driver.get(PropertyKeys.getProperty("baseurl") + "/download");
        downloadPage.WaitUntilElementVisible(downloadPage.downloadPageHeader);
    }

    @Given("download path from settings")
    public void getDownloadPath() {
        driver.get("chrome://settings/downloads");
        String path = downloadPage.downloadPath.getText();
        PropertyKeys.setProperty("downloadPath", path);
    }

    @When("user clicks on download link")
    public void clickDownloadLink() throws InterruptedException {
        downloadPage.WaitUntilElementVisible(downloadPage.downloadLink);
        downloadPage.downloadLink.click();
    }

    @And("wait for three seconds")
    public void waitForThreeSeconds() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("file is downloaded to device")
    public void validateFileDownloaded() {
        boolean flag = false;
        File file = new File(PropertyKeys.getProperty("download.path"));
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].getName().equals(downloadPage.downloadLink.getText())) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }
}
