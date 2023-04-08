package com.internet.stepdefinitions;

import com.internet.pages.DynamicContentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class DynamicContentStepDefinitions {

    DynamicContentPage dynamicContentPage = new DynamicContentPage();

    @Given("User refresh the web page")
    public void user_refresh_the_web_page() {
        dynamicContentPage.refreshPage();
    }
    @Then("User verifies the content of the page is changed")
    public void user_verifies_the_content_of_the_page_is_changed() {
        Assertions.assertFalse(dynamicContentPage.compareContentIfSame(dynamicContentPage.getSourceOfPage()));
    }

}
