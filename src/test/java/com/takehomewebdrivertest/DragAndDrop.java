package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DragAndDrop extends BaseTest {

    @Given("I navigate to the Drag and Drop Page")
    public void iNavigateToTheDragAndDropPage() throws Exception {
        dragAndDropPage.navigateToDragAndDropPage();
    }

    @When("I move the Box A to the Box B location")
    public void iMoveTheBoxAToTheBoxBLocation() throws Exception {
        dragAndDropPage.moveBoxAtoBoxB();
    }

    @Then("The Box A should be the second one")
    public void theBoxAShouldBeTheSecondOne() throws Exception {
        dragAndDropPage.validateBoxAIsTheSecondBox();
    }

    @When("I move the Box B to the Box A location")
    public void iMoveTheBoxBToTheBoxALocation() throws Exception {
        dragAndDropPage.moveBoxBtoBoxA();

    }

    @Then("The Box B should be the first one")
    public void theBoxBShouldBeTheFirstOne() throws Exception {
        dragAndDropPage.validateBoxBIsTheFirstBox();
    }
}

