package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import PageObjects.CheckBoxesPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T03_CheckBoxStepDefs {

    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();


    @And("user verifies checkbox one is not checked by default and checks it")
    public void user_verifies_checkbox_one_is_not_checked_by_default_and_checks_it() {
        Assert.assertFalse(checkBoxesPage.BoxOne.isSelected());
        checkBoxesPage.BoxOne.click();
    }
    @Then("user verifies checkbox two is checked by default and unchecks it")
    public void user_verifies_checkbox_two_is_checked_by_default_and_unchecks_it() {
        Assert.assertTrue(checkBoxesPage.BoxTwo.isSelected());
        checkBoxesPage.BoxTwo.click();
    }

    @Given("user is on the \\/checkboxes page")
    public void userIsOnTheCheckboxesPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + "/checkboxes");
    }

}
