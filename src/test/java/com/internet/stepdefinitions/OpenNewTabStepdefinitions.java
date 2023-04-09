package com.internet.stepdefinitions;

import com.internet.pages.OpenNewTabPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OpenNewTabStepdefinitions {

    OpenNewTabPage openNewTabPage = new OpenNewTabPage();

    @When("User clicks on Click Here")
    public void user_clicks_on_click_here() {
        openNewTabPage.setClickHere();
    }
    @Then("User verifies that new Tab opened with {string}")
    public void user_verifies_that_new_tab_opened_with(String title) {
        Assertions.assertEquals(title,openNewTabPage.returnTitle());
    }

}
