package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.TC_06_DropDown_Page;

public class TC_06_DropDown_StepDefinitions {
    TC_06_DropDown_Page dropDownPage = new TC_06_DropDown_Page();
    Select select;
    @Given("User goes to the DropDown page")
    public void user_goes_to_the_drop_down_page() {
       dropDownPage.dropDownLink.click();
    }
    @When("User can select Option1 and see is selected")
    public void user_can_select_option1_and_see_is_selected() {
        select=new Select(dropDownPage.optionButon);
        select.selectByVisibleText("Option 1");
        Assert.assertTrue(dropDownPage.option1.isSelected());
    }
    @Then("User can select Option2  and see is selected")
    public void user_can_select_option2_and_see_is_selected() {
        select=new Select(dropDownPage.optionButon);
        select.selectByVisibleText("Option 2");
        Assert.assertTrue(dropDownPage.option2.isSelected());
    }


}
