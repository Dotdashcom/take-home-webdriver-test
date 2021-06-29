package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.FileUploadPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileUploadStepDefs {
    FileUploadPage fileUploadPage=new FileUploadPage();
    String path ="/Users/andreisuslov/Downloads/some-file.txt";
    @Given("user is on the file upload page")
    public void user_is_on_the_file_upload_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
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
