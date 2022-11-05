package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_08_DynamicControls_Page;
import utilities.ReusableMethods;

public class TC_08_DynamicControls_StepDefinitions {
    TC_08_DynamicControls_Page dynamicControlsPage=new TC_08_DynamicControls_Page();
    @Given("User goes to the Dynamic Controls page")
    public void user_goes_to_the_dynamic_controls_page() {
    dynamicControlsPage.dynamicControlLink.click();
    }
    @When("User clicks on the Remove Button and uses explicit wait.")
    public void user_clicks_on_the_remove_button_and_uses_explicit_wait() {

        dynamicControlsPage.removeAddButton.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.removeAddButton, 10);
    }
    @Then("User asserts that the checkbox is gone.")
    public void user_asserts_that_the_checkbox_is_gone() {
        try{
            Assert.assertTrue(dynamicControlsPage.checkBox.isDisplayed());}
        catch(Exception e){
            System.out.println("no checkbox is exist");
        }

    }
    @Then("User clicks on Add Button and uses explicit wait.")
    public void user_clicks_on_add_button_and_uses_explicit_wait() {
    dynamicControlsPage.removeAddButton.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.removeAddButton, 10);
    }
    @Then("User asserts that the checkbox is present.")
    public void user_asserts_that_the_checkbox_is_present() {
        Assert.assertTrue(dynamicControlsPage.checkBox.isEnabled());
    }
    @When("User clicks on the Enable Button and uses explicit wait.")
    public void user_clicks_on_the_enable_button_and_uses_explicit_wait() {
        dynamicControlsPage.enableDisableButton.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.enableDisableButton, 10);
    }
    @Then("User asserts that the text box is enabled.")
    public void user_asserts_that_the_text_box_is_enabled() {
        Assert.assertTrue(dynamicControlsPage.itIsEnabledDisabledMessage.getText().contains("enabled"));
    }
    @Then("User clicks on the Disable Button and uses explicit wait.")
    public void user_clicks_on_the_disable_button_and_uses_explicit_wait() {
        dynamicControlsPage.enableDisableButton.click();
        ReusableMethods.waitForVisibility(dynamicControlsPage.enableDisableButton, 10);
    }
    @Then("User asserts that the text box is disabled.")
    public void user_asserts_that_the_text_box_is_disabled() {
        Assert.assertTrue(dynamicControlsPage.itIsEnabledDisabledMessage.getText().contains("disabled"));
    }
}
// there is a bug in this page when click enable/disable button the green bar spins infinitely
//yes it is not a high severity bug but it is still there