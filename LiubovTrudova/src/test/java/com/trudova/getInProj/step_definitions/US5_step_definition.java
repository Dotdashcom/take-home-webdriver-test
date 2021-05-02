package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.DropDownPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US5_step_definition {
    private DropDownPage dropDownPage = new DropDownPage();
    private Select select = new Select(dropDownPage.dropdownSelect);
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("select option1")
    public void select_option1() {
        select.selectByVisibleText("Option 1");
    }

    @Then("verify option1 was selected")
    public void verify_option1_was_selected() {
        String expected = "Option 1";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);
    }


    @Given("select option2")
    public void select_option2() {
        select.selectByVisibleText("Option 2");

    }

    @Then("verify option2 was selected")
    public void verify_option2_was_selected() {
        String expected = "Option 2";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);
    }

}
