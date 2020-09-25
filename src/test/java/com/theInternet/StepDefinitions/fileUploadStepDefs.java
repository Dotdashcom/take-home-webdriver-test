package com.theInternet.StepDefinitions;

import com.theInternet.Pages.fileUploadPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class fileUploadStepDefs {
    fileUploadPage fileUploadPage = new fileUploadPage();

    @Given("User on File Upload page")
    public void user_on_File_Upload_page() {
        System.out.println("Opening the File Upload page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "upload");
        System.out.println("Running to next step");
    }

    @When("Upload Button or Drag and Drop to upload a file.")
    public void upload_Button_or_Drag_and_Drop_to_upload_a_file() {
        String path = "/Users/bilguunamarsaikhan/Desktop/some-file.txt";
        fileUploadPage.chooseFile.sendKeys(path);
        fileUploadPage.upload.click();
    }

    @Then("the file is uploaded.")
    public void the_file_is_uploaded() {
        String expected = "some-file.txt";
        String actual = fileUploadPage.uploadedFile.getText();
        assertEquals(expected, actual);
    }
}
