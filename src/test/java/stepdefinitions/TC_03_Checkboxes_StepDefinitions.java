package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_03_CheckBoxes_Page;

public class TC_03_Checkboxes_StepDefinitions {
    TC_03_CheckBoxes_Page checkBoxesPage=new TC_03_CheckBoxes_Page();
    @When("User goes to go to checkboxes page")
    public void user_goes_to_go_to_checkboxes_page() {
        checkBoxesPage.checkbox.click();
    }
    @Then("User click the checkbox1")
    public void user_click_the_checkbox1() {
    checkBoxesPage.checkboxOne.click();
    }
    @Then("Checkbox1 is selected")
    public void checkbox1_is_selected() {
        Assert.assertTrue(checkBoxesPage.checkboxOne.isDisplayed());

    }
    @Then("User click the checkbox2")
    public void user_click_the_checkbox2() {
    checkBoxesPage.checkboxTwo.click();
    }
    @Then("Checkbox2 is selected")
    public void checkbox2_is_selected() {
        Assert.assertTrue(checkBoxesPage.checkboxTwo.isDisplayed());
    }


}
