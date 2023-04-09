package com.internet.stepdefinitions;

import com.internet.pages.FloatingMenuPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FloatingMenuStepdefinitions {

    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();
    @When("User scroll down to footer")
    public void user_scroll_down_to_footer(){
        floatingMenuPage.scrollToFooter();
    }
    @Then("User verifies that floating menu is still visible")
    public void user_verifies_that_floating_menu_is_still_visible() {
        Assertions.assertTrue(floatingMenuPage.ifMenuisShown());
    }
}
