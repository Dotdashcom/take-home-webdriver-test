package com.theInternet.StepDefinitions;

import com.theInternet.Pages.dynamicControlsPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class dynamicControlsStepDefs {
    dynamicControlsPage dynamicControlsPage = new dynamicControlsPage();
    WebDriverWait wait;

    @Given("User on Dynamic Controls page")
    public void user_on_Dynamic_Controls_page() {
        System.out.println("Opening the Dynamic Controls page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "dynamic_controls");
    }

    @When("User clicks on the Remove Button and uses explicit wait")
    public void user_clicks_on_the_Remove_Button_and_uses_explicit_wait() {
        dynamicControlsPage.removeButton.click();
        wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.message));
    }

    @Then("asserts that the checkbox is gone.")
    public void asserts_that_the_checkbox_is_gone() {
        assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));
    }

    @Then("clicks on Add Button and uses explicit wait.")
    public void clicks_on_Add_Button_and_uses_explicit_wait() {
        dynamicControlsPage.addButton.click();
        wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.message));
    }

    @Then("asserts that the checkbox is present.")
    public void asserts_that_the_checkbox_is_present() {
        assertFalse(dynamicControlsPage.message.isSelected());
    }

    @Then("clicks on the Enable Button and uses explicit wait.")
    public void clicks_on_the_Enable_Button_and_uses_explicit_wait() {
        dynamicControlsPage.enableButton.click();
        wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.message));
    }

    @Then("asserts that the text box is enabled.")
    public void asserts_that_the_text_box_is_enabled() {
        assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));
    }

    @Then("clicks on the Disable Button and uses explicit wait.")
    public void clicks_on_the_Disable_Button_and_uses_explicit_wait() {
        dynamicControlsPage.disableButton.click();
        wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.message));
    }

    @Then("asserts that the text box is disabled.")
    public void asserts_that_the_text_box_is_disabled() {
        assertTrue(dynamicControlsPage.message.getText().equals("It's disabled!"));
    }
}
