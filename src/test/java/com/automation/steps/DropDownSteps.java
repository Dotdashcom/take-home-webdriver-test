package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDownSteps {
    Select select;

    @When("I select {string} from dropdown menu")
    public void i_select_from_dropdown_menu(String optionName) {
        select = new Select(Driver.get().findElement(By.id("dropdown")));
        select.selectByVisibleText(optionName);
    }

    @Then("assert that {string} is selected")
    public void assert_that_is_selected(String optionName) {
        Assert.assertEquals(select.getFirstSelectedOption().getText(), optionName);
    }
}
