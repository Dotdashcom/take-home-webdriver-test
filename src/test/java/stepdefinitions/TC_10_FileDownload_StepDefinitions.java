package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_10_FileDownload_Page;
import utilities.ReusableMethods;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TC_10_FileDownload_StepDefinitions {
    TC_10_FileDownload_Page fileDownloadPage=new TC_10_FileDownload_Page();
    @Given("User goes to the file download page")
    public void user_goes_to_the_file_download_page() {
    fileDownloadPage.fileDownloadlink.click();
    }
    @When("User clicks the some-file.txt")
    public void user_clicks_the_some_file_txt() {
   fileDownloadPage.downloadButton.click();
    }
    @Then("user can see it is downloaded")
    public void user_can_see_it_is_downloaded() {
        String userPath= System.getProperty("user.home");
        String jointSection = File.separator+"Downloads"+File.separator+"some-file.txt";
        String downloadPath= userPath+jointSection;
        ReusableMethods.waitFor(5);
        Assert.assertTrue(Files.exists(Paths.get(downloadPath)));
        File file = new File(downloadPath);
        file.delete();

    }
}
