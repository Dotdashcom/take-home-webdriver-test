package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.DynamicControlsPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US7_step_definition {
    private DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("click on Dynamic Controls link")
    public void click_on_dynamic_controls_link() {
        dynamicControlsPage.dynamicControls.click();
    }


    @Given("clicks on the Remove Button")
    public void clicks_on_the_remove_button() {
        dynamicControlsPage.removeAddBtn.click();
    }

    @When("asserts that the checkbox is gone")
    public void asserts_that_the_checkbox_is_gone() {
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.dMessage));
        Assert.assertTrue(dynamicControlsPage.dMessage.getText().equals("It's gone!"));

    }

    @Then("clicks on Add Button")
    public void clicks_on_add_button() {
        dynamicControlsPage.removeAddBtn.click();
    }

    @Then("asserts that the checkbox is present")
    public void asserts_that_the_checkbox_is_present() {
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.dMessage));
        Assert.assertTrue(dynamicControlsPage.dMessage.getText().equals("It's back!"));

    }

    @Then("clicks on the Enable Button")
    public void clicks_on_the_enable_button() {
        dynamicControlsPage.enableBtn.click();
    }

    @Then("asserts that the text box 'It's enabled!'")
    public void asserts_that_the_text_box_it_s_enabled() {
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.dMessage));
        Assert.assertTrue(dynamicControlsPage.dMessage.getText().equals("It's enabled!"));
    }

    @Then("clicks on the Disable Button")
    public void clicks_on_the_disable_button() {
        dynamicControlsPage.enableBtn.click();
    }

    @Then("asserts that the new text box {string}")
    public void asserts_that_the_new_text_box(String msg) {
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.dMessage));
        Assert.assertTrue(dynamicControlsPage.dMessage.getText().equals(msg));
    }
}
