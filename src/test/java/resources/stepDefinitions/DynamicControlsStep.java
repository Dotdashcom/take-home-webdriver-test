package resources.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.utilities.BaseClass;
import resources.pages.DynamicControlsPages;

public class DynamicControlsStep extends BaseClass{

    @Given("User launches the dynamic controls page")
    public void userLaunchesTheDynamiccontrols() {
        BaseClass tb= new BaseClass();
        String addPath="dynamic_controls";
        tb.setupDownload(addPath);
    }
    @When("User clicks on the RemoveButton")
    public void clickRemoveButton() {
        DynamicControlsPages dc= new DynamicControlsPages();
        dc.userClickRemoveButton();
    }

    @Then("Verify that the checkbox is gone.")
    public void checkBoxNotFound() {
        DynamicControlsPages dc= new DynamicControlsPages();
        boolean eleNotPresent=dc.userCheckBoxNotFound();
        Assert.assertTrue(eleNotPresent);
    }
    @When("User clicks on AddButton")
    public void clickAddButton() {
        DynamicControlsPages dc= new DynamicControlsPages();
        dc.userClickAddButton();
    }
    @Then("Verify that the checkbox is present")
    public void checkboxPresent() {
        DynamicControlsPages dc= new DynamicControlsPages();
        boolean elepresent=dc.userCheckBoxPresent();
        Assert.assertTrue(elepresent);
    }
    @When("User clicks on the EnableButton")
    public void clickEnableButton() {
        DynamicControlsPages dc= new DynamicControlsPages();
        dc.userClickEnableButton();
    }
    @Then("Verify that the text box is enabled")
    public void checkTextBoxEnabled() {
        DynamicControlsPages dc= new DynamicControlsPages();
        boolean eleEnabled=dc.userCheckTextBoxEnabled();
        Assert.assertTrue(eleEnabled);
    }
    @When("User clicks on the DisableButton")
    public void clickDisableButton() {
        DynamicControlsPages dc= new DynamicControlsPages();
        dc.userClickDisableButton();
    }
    @Then("Verify that the text box is disabled")
    public void textBoxDisabled() {
        DynamicControlsPages dc= new DynamicControlsPages();
        boolean eleEnabled=dc.userTextBoxDisabled();
        Assert.assertFalse(eleEnabled);
    }
}
