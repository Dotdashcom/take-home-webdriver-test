package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dropdown {

@Given("the user is on the homepage page for dropdown")
public void the_user_is_on_the_homepage_page_for_dropdown() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/dropdown");

}

@When("the user selects option one and validates option one")
public void the_user_selects_option_one_and_validates_option_one() {
    // Write code here that turns the phrase above into concrete actions
    WebElement selectbox = TestRunner.driver.findElement(By.id("dropdown"));
    Select selection = new Select(selectbox);
    selection.selectByVisibleText("Option 1");
    Assert.assertEquals("Option 1", selection.getFirstSelectedOption().getText());
}
@When("the user selects option two")
public void the_user_selects_option_two() {
    // Write code here that turns the phrase above into concrete actions
    WebElement selectbox = TestRunner.driver.findElement(By.id("dropdown"));
    Select selection = new Select(selectbox);
    selection.selectByVisibleText("Option 2");
    
}
@Then("option two is validated")
public void option_two_is_validated() {
    // Write code here that turns the phrase above into concrete actions
    WebElement selectbox = TestRunner.driver.findElement(By.id("dropdown"));
    Select selection = new Select(selectbox);
    Assert.assertEquals("Option 2", selection.getFirstSelectedOption().getText());
}

    
}
