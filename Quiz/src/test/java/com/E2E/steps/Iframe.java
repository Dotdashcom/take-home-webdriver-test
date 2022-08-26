package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Iframe {
@Given("the user is on the file iframe page")
public void the_user_is_on_the_file_iframe_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/iframe");
    
}


@When("Test switches to Iframe and types some text")
public void test_switches_to_Iframe_and_types_some_text() {
    // Write code here that turns the phrase above into concrete actions
    
    TestRunner.driver.switchTo().frame(TestRunner.driver.findElement(By.id("mce_0_ifr")));
    TestRunner.driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("This is a test");
    
}
@Then("Test asserts that the typed text is as expected")
public void test_asserts_that_the_typed_text_is_as_expected() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals("Your content goes here.This is a test", TestRunner.driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText());
}
    
}
