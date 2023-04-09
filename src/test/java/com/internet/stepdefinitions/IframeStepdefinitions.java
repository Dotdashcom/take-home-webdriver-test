package com.internet.stepdefinitions;

import com.internet.pages.IframePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class IframeStepdefinitions {

    IframePage iframePage = new IframePage();
    @When("User writes into Iframe")
    public void user_writes_into_iframe() {
        iframePage.writeText();
    }
    @Then("User verifies written text is intact")
    public void user_verifies_written_text_is_intact() {
        Assertions.assertEquals("Hello World",iframePage.getText());
    }
}
