package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicControls {


@Given("the user is on the homepage page for Dynamic Controls")
public void the_user_is_on_the_homepage_page_for_Dynamic_Controls() {
    // Write code here that turns the phrase above into concrete actions

    TestRunner.driver.get("http://localhost:7080/dynamic_controls");
}

@When("Test clicks on the Remove Button and uses explicit wait")
public void test_clicks_on_the_Remove_Button_and_uses_explicit_wait() {
    WebElement removeButton = TestRunner.driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
    removeButton.click();

    TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
}
@When("Test asserts that the checkbox is gone")
public void test_asserts_that_the_checkbox_is_gone() {
    Assert.assertTrue(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id='checkbox']"), "A Checkbox").apply(TestRunner.driver));
}
@When("Test clicks on Add Button and uses explicit wait.")
public void test_clicks_on_Add_Button_and_uses_explicit_wait() {
    WebElement addButton = TestRunner.driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
    addButton.click();
    TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkbox']")));
}
@When("Test asserts that the checkbox is present")
public void test_asserts_that_the_checkbox_is_present() {
    Assert.assertTrue(TestRunner.driver.findElement(By.xpath("//*[@id='checkbox']")).isDisplayed());

}
@When("Test clicks on the Enable Button and uses explicit wait")
public void test_clicks_on_the_Enable_Button_and_uses_explicit_wait() {
    WebElement enableButton = TestRunner.driver.findElement(By.xpath("//*[@id='input-example']/button"));
    enableButton.click();
    TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
}
@When("Test asserts that the text box is enabled")
public void test_asserts_that_the_text_box_is_enabled() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertTrue(TestRunner.driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled());
}
@When("Test clicks on the Disable Button and uses explicit wait")
public void test_clicks_on_the_Disable_Button_and_uses_explicit_wait() {
    // Write code here that turns the phrase above into concrete actions
    WebElement addButton = TestRunner.driver.findElement(By.xpath("//*[@id='input-example']/button"));
    addButton.click();
    TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
}
@Then("Test asserts that the text box is disabled")
public void test_asserts_that_the_text_box_is_disabled() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertFalse(TestRunner.driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled());
}

    
}
