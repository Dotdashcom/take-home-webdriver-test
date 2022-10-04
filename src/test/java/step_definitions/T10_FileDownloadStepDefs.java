package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FileDownloadPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T10_FileDownloadStepDefs {

    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    @Given("user is on the {string} Download page")
    public void user_is_on_the_download_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);

    }
    @When("user clicks on the file")
    public void user_clicks_on_the_file() throws InterruptedException {
        fileDownloadPage.fileLink.click();
        Thread.sleep(200);
    }
    @Then("user verifies that the file is downloaded")
    public void user_verifies_that_the_file_is_downloaded() {
        try {
            Assert.assertTrue("file not found in " + fileDownloadPage.directory, fileDownloadPage.fileDownload("some-file.txt"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
