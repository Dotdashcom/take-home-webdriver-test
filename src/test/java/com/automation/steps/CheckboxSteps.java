package com.automation.steps;

import com.automation.pages.CheckBoxPage;
import com.automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CheckboxSteps {

    CheckBoxPage checkBoxPage = new CheckBoxPage();

    @Then("verify {string} is {string}")
    public void verify_is(String checkbox, String value) {
        boolean actualValue = checkBoxPage.getCheckBox(checkbox).isSelected();
        System.out.println(actualValue);
        if(value.equals("selected"))  Assert.assertTrue(actualValue);
        else if(value.equals("not selected")) Assert.assertFalse(actualValue);
    }

    @When("I click checkboxes")
    public void i_click_checkboxes() {
        checkBoxPage.checkboxes.forEach(WebElement::click);
    }

}
