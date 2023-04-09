package com.internet.stepdefinitions;

import com.internet.pages.DragAndDropPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class DragAndDropStepDefinitions {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Given("User drags point A and then Drop to Point B Location")
    public void user_drags_point_a_and_then_drop_to_point_b_location() throws InterruptedException {
       dragAndDropPage.dragAndDrop();
    }
    @Then("User observes that position of Point A is switched with Point B")
    public void user_observes_that_position_of_point_a_is_switched_with_point_b() {
        Assertions.assertTrue(dragAndDropPage.confirmIfSwitched());
    }







}
