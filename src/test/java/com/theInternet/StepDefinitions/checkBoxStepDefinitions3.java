package com.theInternet.StepDefinitions;

import com.theInternet.Pages.checkBoxPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class checkBoxStepDefinitions3 {
    checkBoxPage checkBoxPage = new checkBoxPage();

    @Given("User on Checkboxes Page")
    public void user_on_Checkboxes_Page() {
        System.out.println("Opening the Checkboxes page");
        Driver.get().get(ConfigurationReader.get("baseURL")+"checkboxes");
        String expected = "Checkboxes";
        String actual = checkBoxPage.headerMsg.getText();
        assertThat(expected, is(actual));
    }

    @When("checkbox {int} is unchecked and checkbox {int} is checked")
    public void checkbox_is_unchecked_and_checkbox_is_checked(int int1, int int2) {
        int1 = int1-1;
        int2 = int2-1;
        assertTrue(!checkBoxPage.checkboxes.get(int1).isSelected());
        assertTrue(checkBoxPage.checkboxes.get(int2).isSelected());
    }

    @When("User checks checkbox {int} and unchecks checkbox {int}")
    public void user_checks_checkbox_and_unchecks_checkbox(int int1, int int2) {
        int1 = int1-1;
        int2 = int2-1;
        checkBoxPage.checkboxes.get(int1).click();
        checkBoxPage.checkboxes.get(int2).click();
    }

    @Then("checkbox {int} is checked and checkbox {int} is unchecked")
    public void checkbox_is_checked_and_checkbox_is_unchecked(int int1, int int2) {
        int1 = int1-1;
        int2 = int2-1;
        assertTrue(checkBoxPage.checkboxes.get(int1).isSelected());
        assertTrue(!checkBoxPage.checkboxes.get(int2).isSelected());
    }

}
