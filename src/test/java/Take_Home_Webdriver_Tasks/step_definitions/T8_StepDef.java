package Take_Home_Webdriver_Tasks.step_definitions;

import Take_Home_Webdriver_Tasks.pages.DynamicPage;
import Take_Home_Webdriver_Tasks.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class T8_StepDef {

    DynamicPage dynamicPage = new DynamicPage();

    @When("user clicks on Remove Button")
    public void user_clicks_on_remove_button() {
        Assert.assertTrue(dynamicPage.checkBox.isDisplayed());

        dynamicPage.remove_add_Btn.click();

    }
    @Then("verify that the checkbox is gone")
    public void verify_that_the_checkbox_is_gone() {

        BrowserUtils.waitForClickAbility(dynamicPage.remove_add_Btn,10);
        Assert.assertEquals("It's gone!", dynamicPage.actionMsg.getText());

    }
    @When("user clicks on Add Button")
    public void user_clicks_on_add_button() {

        dynamicPage.remove_add_Btn.click();
    }
    @Then("verify that the checkbox is present")
    public void verify_that_the_checkbox_is_present() {
        BrowserUtils.waitForClickAbility(dynamicPage.remove_add_Btn,10);
        Assert.assertEquals("It's back!", dynamicPage.actionMsg.getText());

    }
    @When("user clicks on the Enable Button")
    public void user_clicks_on_the_enable_button() {

        dynamicPage.enable_disable_Btn.click();

    }
    @Then("verify that the text box is enabled")
    public void verify_that_the_text_box_is_enabled() {

        BrowserUtils.waitForClickAbility(dynamicPage.enable_disable_Btn,10);
        Assert.assertEquals("It's enabled!", dynamicPage.actionMsg.getText());

    }
    @When("user clicks on the Disable Button")
    public void user_clicks_on_the_disable_button() {

        dynamicPage.enable_disable_Btn.click();

    }
    @Then("verify that the text box is disabled")
    public void verify_that_the_text_box_is_disabled() {

        BrowserUtils.waitForClickAbility(dynamicPage.enable_disable_Btn,10);
        Assert.assertEquals("It's disabled!", dynamicPage.actionMsg.getText());

    }


}
