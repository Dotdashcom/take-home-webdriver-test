package com.takehomewebdrivertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContextMenu extends BaseTest {

    @Given("I navigate to the Context Menu Page")
    public void iNavigateToTheContextMenuPage() throws Exception {
        contextMenuPage.navigateToContextMenuPage();
    }

    @When("I right click on the box")
    public void iRightClickOnTheBox() throws Exception {
        contextMenuPage.rightClickOnTheBox();
    }

    @Then("A Javascript alert should appear")
    public void aJavascriptAlertShouldAppear() throws Exception {
        contextMenuPage.validateJavaScriptAlert();
    }
}

