package com.interview.step_definitions;

import com.interview.pages.FileUploadPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class fileUpload_stepDefinition {
    FileUploadPage fileUploadPage=new FileUploadPage();
    String path ="/Users/minibae/Downloads/some-file.txt";
    @Given("user is on the file upload page")
    public void user_is_on_the_file_upload_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/upload");
    }




    @When("user click chooseFIle button and select file")
    public void user_click_choose_f_ile_button_and_select_file() {
fileUploadPage.chooseFileButton.sendKeys(path);
    }
    @When("click the upload button")
    public void click_the_upload_button() {
fileUploadPage.uploadButton.click();
    }
    @Then("user will see File is Uploaded!")
    public void user_will_see_file_is_uploaded() {
        Assert.assertTrue(fileUploadPage.fileUploadedMessage.getText().equals("File Uploaded!"));
    }

}
