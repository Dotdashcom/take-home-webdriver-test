package com.E2E.steps;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DownloadFile {

@Given("the user is on the file download page")
public void the_user_is_on_the_file_download_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/download");
}

@When("the user clicks the download file button")
public void the_user_clicks_the_download_file_button() {
    // Write code here that turns the phrase above into concrete actions
    WebElement downloadButton = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/a"));
    downloadButton.click();
}
@Then("then it asserts we the page was downloaded")
public void then_it_asserts_we_the_page_was_downloaded() {
    // Write code here that turns the phrase above into concrete actions
    File f = new File(System.getProperty("user.dir")+"/some-text.txt"); 
    Assert.assertTrue(f.exists());
}

    
}
