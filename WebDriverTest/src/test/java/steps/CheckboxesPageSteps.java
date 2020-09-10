package steps;

import base.Functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckboxesPageSteps extends Functions {

    @When("user clicks on checkboxes")
    public void user_clicks_on_checkboxes() {

        // clicking on unchecked checkboxes
        checkboxes.clickCheckbox();

    }

    @Then("user sees {string} and {string} work correctly")
    public void user_sees_and_work_correctly(String string, String string2) {

        // verifying all checkboxes are selected
        Assert.assertTrue(checkboxes.checkAllSelected());

        // clicking on all checked checkboxes
        checkboxes.clickUnCheckbox();

        // checking all checkboxes are not selected
        Assert.assertFalse(checkboxes.checkAllSelected());

    }
}
