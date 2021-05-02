package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.CheckBoxPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US2_step_definition {
    private CheckBoxPage checkBoxPage = new CheckBoxPage();


    @Given("click checkboxes link")
    public void click_checkboxes_link() {
        checkBoxPage.checkboxes.click();
    }

    @Given("check checkbox1")
    public void check_checkbox1() {
        checkBoxPage.checkBox1.click();

    }

    @Then("verify checkbox1 was selected")
    public void verify_checkbox1_was_selected() {
        boolean actual = checkBoxPage.checkBox1.isSelected();
        Assert.assertTrue(actual);
    }

    @Then("uncheck checkbox1 verify checkbox1 unselected")
    public void uncheck_checkbox1_verify_checkbox1_unselected() {

        checkBoxPage.checkBox1.click();
        boolean actual = checkBoxPage.checkBox1.isSelected();
        Assert.assertFalse(actual);
    }

    @Given("uncheck checkbox2")
    public void uncheck_checkbox2() {
        checkBoxPage.checkBox2.click();
    }


    @Then("verify checkbox2 was unselected")
    public void verify_checkbox2_was_unselected() {
        Assert.assertFalse(checkBoxPage.checkBox2.isSelected());
    }

    @Then("check checkbox2 verify checkbox2 unselected")
    public void check_checkbox2_verify_checkbox2_unselected() {
        checkBoxPage.checkBox2.click();
        Assert.assertTrue(checkBoxPage.checkBox2.isSelected());
    }


}
