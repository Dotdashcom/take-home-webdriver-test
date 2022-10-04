package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FileUploadPage;
import utilities.ConfigurationReader;
import utilities.Driver;

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
        fileUploadPage.chooseFileBtn.sendKeys("/Users/elvindanyarov/Desktop/WebPages/attachment_108929946.jpeg");
        fileUploadPage.uploadBtn.click();
    }
}
