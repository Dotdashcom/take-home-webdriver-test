package com.E2E.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MouseHover {

@Given("the user is on the file MouserHover page")
public void the_user_is_on_the_file_MouserHover_page() {
    // Write code here that turns the phrase above into concrete actions
    TestRunner.driver.get("http://localhost:7080/hovers");
}


@When("Test does a mouse hover on each image")
public void test_does_a_mouse_hover_on_each_image() {
    // Write code here that turns the phrase above into concrete actions
    Actions action = new Actions(TestRunner.driver);
	WebElement person = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
	action.moveToElement(person).perform();
    Assert.assertTrue(TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).isDisplayed());
    WebElement person2 = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
	action.moveToElement(person2).perform();
    Assert.assertTrue(TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div")).isDisplayed());
		

    //*[@id="content"]/div/div[2]/div/h5
}
@Then("Test asserts that additional information is displayed for each image")
public void test_asserts_that_additional_information_is_displayed_for_each_image() {
    Actions action = new Actions(TestRunner.driver);
    WebElement person = TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));
	action.moveToElement(person).perform();
    Assert.assertTrue(TestRunner.driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div")).isDisplayed());
}
}
