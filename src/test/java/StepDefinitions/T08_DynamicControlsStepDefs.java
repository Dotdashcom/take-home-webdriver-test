package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.DynamicControlsPage;
import Utilities.ConfigurationReader;
import Utilities.Driver;

public class T08_DynamicControlsStepDefs {
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Given("user is on the {string} Dynamic Controls page")
    public void user_is_on_the_dynamic_controls_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);

    }

    @When("user clicks on the Remove Button and uses explicit wait.")
    public void user_clicks_on_the_remove_button_and_uses_explicit_wait() {
        dynamicControlsPage.removeBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar2));
    }

    @Then("asserts that the checkbox is gone.")
    public void asserts_that_the_checkbox_is_gone() {
        Assert.assertEquals("It's gone!", dynamicControlsPage.removeConfirmation.getText());
    }

    @Then("user clicks on Add Button and uses explicit wait.")
    public void user_clicks_on_add_button_and_uses_explicit_wait() {
        dynamicControlsPage.addBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.addMessage));
    }

    @Then("user asserts that the checkbox is present.")
    public void user_asserts_that_the_checkbox_is_present() {
        Assert.assertTrue(dynamicControlsPage.checkbox.isDisplayed());
    }

    @Then("user clicks on the Enable Button and uses explicit wait.")
    public void user_clicks_on_the_enable_button_and_uses_explicit_wait() {
        dynamicControlsPage.enableBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar2));
    }

    @Then("user asserts that the text box is enabled.")
    public void user_asserts_that_the_text_box_is_enabled() {
        Assert.assertEquals("It's enabled!", dynamicControlsPage.addMessage.getText());
        System.out.println(dynamicControlsPage.addMessage.getText());
    }

    @Then("user clicks on the Disable Button and uses explicit wait.")
    public void user_clicks_on_the_disable_button_and_uses_explicit_wait() {
        dynamicControlsPage.disableBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar2));
    }

    @Then("user asserts that the text box is disabled.")
    public void user_asserts_that_the_text_box_is_disabled() {
        Assert.assertEquals("It's disabled!", dynamicControlsPage.addMessage.getText());
        System.out.println(dynamicControlsPage.addMessage.getText());
    }


}
