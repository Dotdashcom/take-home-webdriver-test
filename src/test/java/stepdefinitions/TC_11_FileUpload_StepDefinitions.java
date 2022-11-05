package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.TC_11_FileUpload_Page;
import utilities.Driver;

import java.io.File;

public class TC_11_FileUpload_StepDefinitions {
    TC_11_FileUpload_Page fileUploadPage=new TC_11_FileUpload_Page();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Given("User goes to the file upload page")
    public void user_goes_to_the_file_upload_page() {
    fileUploadPage.fileUploadlink.click();
    }
    @When("User clicks choose file button and select")
    public void user_clicks_choose_file_button_and_select() {
        js.executeScript("arguments[0].click();",fileUploadPage.chooseFileButton);
    }
    @When("User clicks the upload button")
    public void user_clicks_the_upload_button() {
        String userPath=System.getProperty("user.dir");
        String jointSection= File.separator+"answer.txt";
        String uploadFile= userPath+jointSection;
        fileUploadPage.chooseFileButton.sendKeys(uploadFile);
        fileUploadPage.uploadButton.click();

    }
    @Then("User can see File is Uploaded!")
    public void user_can_see_file_is_uploaded() {
        Assert.assertTrue(fileUploadPage.fileUploadedMessage.getText().equals("File Uploaded!"));
    }
}
