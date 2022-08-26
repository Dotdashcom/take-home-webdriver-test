package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkboxes {




@Given("the user is on the homepage page")
public void the_user_is_on_the_homepage_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/checkboxes");
}

@When("the user clicks the check boxes")
public void the_user_clicks_the_check_boxes() {
    // Write code here that turns the phrase above into concrete actions
    WebElement checkbox1 = TestRunner.driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
    WebElement checkbox2 = TestRunner.driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

    checkbox1.click();
    Assert.assertTrue(checkbox1.isSelected());

    checkbox2.click();
    Assert.assertFalse(checkbox2.isSelected());


}
@When("the user unclicks the check boxes")
public void the_user_unclicks_the_check_boxes() {
    // Write code here that turns the phrase above into concrete actions
    WebElement checkbox1 = TestRunner.driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
    WebElement checkbox2 = TestRunner.driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
    
    checkbox1.click();
    checkbox2.click();

}
@Then("the user verfies both boxes are checked")
public void the_user_verfies_both_boxes_are_checked() {
    // Write code here that turns the phrase above into concrete actions
    WebElement checkbox1 = TestRunner.driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
    WebElement checkbox2 = TestRunner.driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
   

    Assert.assertFalse(checkbox1.isSelected());
    Assert.assertTrue(checkbox2.isSelected());


}



    
}
