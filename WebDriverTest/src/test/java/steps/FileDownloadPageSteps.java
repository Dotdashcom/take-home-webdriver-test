package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileDownloadPageSteps extends Functions {

    @When("user clicks link to download file")
    public void user_clicks_link_to_download_file() {

        click(fileDownloadPage.link);
    }

    @Then("user sees file {string} downloaded to the folder {string}")
    public void user_sees_file_downloaded_to_the_folder(String fileName, String downloadFilePath) {

        Assert.assertTrue(isFileDownloaded(downloadFilePath, fileName));
    }

}
