package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import PageObjects.FileUploadPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T11_FileUploadStepDefs {

    FileUploadPage fileUploadPage = new FileUploadPage();

    @Given("user is on {string} File Upload page")
    public void user_is_on_file_upload_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }

    @Then("user should be abel to assert successful completion")
    public void user_should_be_abel_to_assert_successful_completion() {
        Assert.assertEquals("File Uploaded!", fileUploadPage.successMessage.getText());
    }

    @When("user selects and uploads the file with Upload Button")
    public void userSelectsAndUploadsTheFileWithUploadButton() {

        //This test might fail because path is directing to my local file
        fileUploadPage.chooseFileBtn.sendKeys("/Users/foroghmulk/Desktop/Omid.jpeg");
        fileUploadPage.uploadBtn.click();
    }
}
