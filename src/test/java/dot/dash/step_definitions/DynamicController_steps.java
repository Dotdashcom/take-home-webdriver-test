package dot.dash.step_definitions;

import dot.dash.pages.DyControl;
import dot.dash.utilities.Driver;
import dot.dash.utilities.WaitUntil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class DynamicController_steps {
    DyControl dyc = new DyControl();
    @When("user clicks on the Remove Button")
    public void user_clicks_on_the_remove_button() {
        dyc.removeBtn.click();
        WaitUntil.invisibilityOf(dyc.loadBar);
    }
    @Then("verify that the checkbox is gone")
    public void verify_that_the_checkbox_is_gone() {
        Assert.assertTrue(dyc.checkboxGoneMessage.isDisplayed());
    }
    @When("user clicks on Add Button")
    public void user_clicks_on_add_button() {
        dyc.addCheckboxBtn.click();
        WaitUntil.invisibilityOf(dyc.loadBar);
    }
    @Then("verify that the checkbox is present")
    public void verify_that_the_checkbox_is_present() {
        Assert.assertTrue(dyc.checkbox.isDisplayed());
        Driver.getDriver().navigate().refresh();
        dyc = new DyControl();
    }
    @When("clicks on the Enable Button")
    public void clicks_on_the_enable_button() {
        dyc.enableBtn.click();
        WaitUntil.invisibilityOf(dyc.loadBar);
    }
    @Then("verify that the text box is enabled")
    public void verify_that_the_text_box_is_enabled() {
        Assert.assertTrue(dyc.textBox.isEnabled());
    }
    @When("clicks on the Disable Button")
    public void clicks_on_the_disable_button() {
        dyc.disableBtn.click();
        WaitUntil.invisibilityOf(dyc.loadBar);
    }
    @Then("verify that the text box is disabled")
    public void verify_that_the_text_box_is_disabled() {
        Assert.assertTrue(dyc.textBox.isDisplayed());
    }


}
