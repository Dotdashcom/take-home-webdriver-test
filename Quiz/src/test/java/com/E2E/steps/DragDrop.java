package com.E2E.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.E2E.runner.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DragDrop {

@Given("the user is on the homepage page for drag drop")
    public void the_user_is_on_the_homepage_page_for_drag_drop() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.driver.get("http://localhost:7080/drag_and_drop");

}



@When("the user grabs the first box and drops it on the second box")
public void the_user_grabs_the_first_box_and_drops_it_on_the_second_box() {
    // Write code here that turns the phrase above into concrete actions
WebElement dragElement = TestRunner.driver.findElement(By.xpath("//*[@id='column-a']"));
WebElement dropElement = TestRunner.driver.findElement(By.xpath("//*[@id='column-b']"));


TestRunner.driver.manage().window().maximize();
Actions builder = new Actions(TestRunner.driver);
builder.dragAndDrop(dropElement, dragElement).build().perform();
	

}



@Then("the user verfies both boxes are moved")
public void the_user_verfies_both_boxes_are_moved() {

    WebElement boxA = TestRunner.driver.findElement(By.xpath("//*[@id='column-a']"));

    Assert.assertEquals("B", boxA.getText());
}
    
}
