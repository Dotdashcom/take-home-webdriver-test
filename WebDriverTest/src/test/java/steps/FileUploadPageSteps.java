package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileUploadPageSteps extends Functions {

    @When("user chooses the file {string} to upload and clicks on Upload button")
    public void user_chooses_the_file_to_upload_and_clicks_on_Upload_button(String filePath) {

        fileUploadPage.chooseFileBtn.sendKeys(filePath);
        click(fileUploadPage.uploadBtn);
    }

    @Then("user sees {string} file successfully uploaded")
    public void user_sees_file_successfully_uploaded(String fileName) {

        Assert.assertEquals(fileName, fileUploadPage.uploadedFile.getText());

    }
}
