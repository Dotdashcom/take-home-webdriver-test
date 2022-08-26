package com.E2E.steps;

import org.openqa.selenium.By;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadFile {

@Given("the user is on the file upload page")
public void the_user_is_on_the_file_upload_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/upload");
}
@When("the user clicks drops the file they want to upload")
public void the_user_clicks_drops_the_file_they_want_to_upload() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys("/Users/cameronhauser/Desktop/GitHub/newproject/Quiz/src/test/java/com/E2E/steps/some-file.txt");

}
@Then("the user uploads file")
public void the_user_uploads_file() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.findElement(By.xpath("//*[@id='file-submit']")).click();
}
    
}
