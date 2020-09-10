package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DragAndDropPageSteps extends Functions {

    @When("user drags one square and drops on another square")
    public void user_drags_one_square_and_drops_on_another_square() {

        drugAndDrop(drugAndDrop.squareA, drugAndDrop.squareB);
    }

    @Then("user sees boxes {string} and {string} are swapped")
    public void user_sees_boxes_and_are_swapped(String headerA, String headerB) {

        Assert.assertEquals("Issue: Squares were not swapped" , headerB, secureArea.getMessage(drugAndDrop.headerA));

    }

}
