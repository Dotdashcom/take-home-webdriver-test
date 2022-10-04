package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DropDownPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T06_DropDownStepDefs {

    DropDownPage dropDownPage = new DropDownPage();

    @When("user selects option one and asserts that it is selected")
    public void userSelectsOptionOneAndAssertsThatItIsSelected() {
        dropDownPage.dropdownBtn.click();
        Select select = new Select(dropDownPage.dropdownBtn);
        select.selectByValue("1");
        String actual = select.getFirstSelectedOption().getText();
        String expected = "Option 1";
        Assert.assertEquals(expected, actual);
    }

    @Then("user selects option two and asserts that it is selected")
    public void userSelectsOptionTwoAndAssertsThatItIsSelected() {
        dropDownPage.dropdownBtn.click();
        Select select = new Select(dropDownPage.dropdownBtn);
        select.selectByValue("2");
        String actual = select.getFirstSelectedOption().getText();
        String expected = "Option 2";
        Assert.assertEquals(expected, actual);
    }

    @Given("user is on the {string} DropDown page")
    public void userIsOnTheDropDownPage(String endpointDrop) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpointDrop);

    }
}
