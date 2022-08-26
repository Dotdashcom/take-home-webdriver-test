package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FloatingMenu {
@Given("the user is on the page for floating menu")
public void the_user_is_on_the_page_for_floating_menu() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/floating_menu");
}


@When("User is going scroll through page")
public void user_is_going_scroll_through_page() {
    // Write code here that turns the phrase above into concrete actions
    JavascriptExecutor jse = (JavascriptExecutor)TestRunner.driver;
    jse.executeScript("window.scrollBy(0,100)");
}
@Then("Test asserts that the floating menu is still displayed.")
public void test_asserts_that_the_floating_menu_is_still_displayed() {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertTrue(TestRunner.driver.findElement(By.xpath("//*[@id='menu']/ul/li[2]/a")).isDisplayed());
}

    
}
