package com.dotdash.step_definitions;

import com.dotdash.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckboxStepDefs extends BaseStep{

    @When("I select checkbox 1")
    public void i_select_checkbox1() {
        BrowserUtils.waitForClickability(pages.checkboxPage().checkbox1, 5);
        BrowserUtils.selectCheckBox(pages.checkboxPage().checkbox1, true );
    }
    @Then("Checkbox 1 should be selected")
    public void checkbox_should_be_selected() {
        assertThat("Checkbox 1 is selected",pages.checkboxPage().checkbox1.isSelected());
    }
    @When("I unselect checkbox 2")
    public void i_unselect_checkbox2() {
        BrowserUtils.selectCheckBox(pages.checkboxPage().checkbox2, false );
    }
    @Then("Checkbox 2 should be unselected")
    public void checkbox_should_be_unselected() {
        assertThat("Checkbox2 is not selected",!pages.checkboxPage().checkbox2.isSelected());
    }

}
