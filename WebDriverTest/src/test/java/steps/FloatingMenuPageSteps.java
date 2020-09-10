package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FloatingMenuPageSteps extends Functions {

    @When("user scrolls down {int} the page")
    public void user_scrolls_down_the_page(Integer pixels) {

        scrollDown(pixels);

    }

    @Then("user sees the menu buttons are visible and accessible")
    public void user_sees_the_menu_buttons_are_visible_and_accessible() {

        Assert.assertTrue(floatingMenuPage.allMenuButtonsVisible());
    }

}
