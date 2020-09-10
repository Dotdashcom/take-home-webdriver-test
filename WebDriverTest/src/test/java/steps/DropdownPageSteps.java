package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DropdownPageSteps extends Functions {

    @When("user selects {string}")
    public void user_selects(String option) {

        selectDDOption(dropdownPage.dd, option);
    }

    @Then("{string} selected successfully")
    public void selected_successfully(String expectedOption) {

        Assert.assertEquals("", expectedOption, getSelectedDDOption(dropdownPage.dd));
    }
}
