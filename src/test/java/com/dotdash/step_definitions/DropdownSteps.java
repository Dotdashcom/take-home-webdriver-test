package com.dotdash.step_definitions;

import com.dotdash.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DropdownSteps extends BaseStep {
    @When("I select {string} from the drop down menu")
    public void i_select_option_and_option_from_the_drop_down_menu(String str) {
        BrowserUtils.waitForVisibility(pages.dropdownPage().dropdown, 5);
        Select options = new Select(pages.dropdownPage().dropdown);
        options.selectByVisibleText(str);
    }

    @Then("I assert {string} are selected")
    public void i_assert_option_and_option_are_selected(String str) {
        Select select = new Select(pages.dropdownPage().dropdown);
        String actual = select.getFirstSelectedOption().getText();
        assertThat(actual, containsString(str) );
    }

}
