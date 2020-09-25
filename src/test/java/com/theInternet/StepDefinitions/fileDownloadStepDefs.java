package com.theInternet.StepDefinitions;

import com.theInternet.Pages.fileDownloadPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class fileDownloadStepDefs {

    fileDownloadPage fileDownloadPage = new fileDownloadPage();

    @Given("User on File Download page")
    public void user_on_File_Download_page() {
        System.out.println("Opening the File Download page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "download");
    }

    @When("clicks on the file.")
    public void clicks_on_the_file() {
        fileDownloadPage.file.click();
    }

    @Then("the file is downloaded.")
    public void the_file_is_downloaded() {
        String fileName = fileDownloadPage.file.getText();
        String path = "/Users/bilguunamarsaikhan/Downloads/some-file.text";
        File file = new File(path);
        assertTrue(file.getPath().equals(path));
    }

}
