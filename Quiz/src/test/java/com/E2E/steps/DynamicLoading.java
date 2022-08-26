package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicLoading {

@Given("the user is on the page for dynamic loading")
public void the_user_is_on_the_page_for_dynamic_loading() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/dynamic_loading/2");
}


@When("Test clicks the start button and uses explicit wait")
public void test_clicks_the_start_button_and_uses_explicit_wait() {
    WebElement startButton = TestRunner.driver.findElement(By.xpath("//*[@id='start']/button"));
    startButton.click();
    TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));

}
@Then("Test asserts that “Hello World!” text is displayed.")
public void test_asserts_that_Hello_World_text_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals("Hello World!", TestRunner.driver.findElement(By.xpath("//*[@id='finish']/h4")).getText());
}
    
}
