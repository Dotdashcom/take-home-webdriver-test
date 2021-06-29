package com.new_york_remote.step_definitions;

import com.new_york_remote.pages.DynamicControlPage;
import com.new_york_remote.utilities.ConfigReader;
import com.new_york_remote.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlStepDefs {
    DynamicControlPage dynamicControlPage=new DynamicControlPage();

    @Given("user is on the Dynamic Controls page")
    public void user_is_on_the_dynamic_controls_page() {
        String url= ConfigReader.getPropertiesValue("baseUrl");
        Driver.getDriver().get(url+"/dynamic_controls");
    }




    @When("Test clicks on the Remove Button and uses explicit wait.")
    public void test_clicks_on_the_remove_button_and_uses_explicit_wait() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        dynamicControlPage.RemoveAddButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(dynamicControlPage.itIsGoneMessage));

    }
    @Then("Test asserts that the checkbox is gone.")
    public void test_asserts_that_the_checkbox_is_gone() {
        try{Assert.assertTrue(!dynamicControlPage.checkBox.isDisplayed());}
        catch(Exception e){
            System.out.println("no checkbox is exist");
        }
    }
    @Then("Test clicks on Add Button and uses explicit wait.")
    public void test_clicks_on_add_button_and_uses_explicit_wait() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        dynamicControlPage.RemoveAddButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(dynamicControlPage.checkBox));
    }
    @Then("Test asserts that the checkbox is present.")
    public void test_asserts_that_the_checkbox_is_present() {
        Assert.assertTrue(dynamicControlPage.checkBox.isEnabled());

    }







    @When("Test clicks on the Enable Button and uses explicit wait.")
    public void test_clicks_on_the_enable_button_and_uses_explicit_wait() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        dynamicControlPage.EnableDisableButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(dynamicControlPage.itIsEnabledDisabledMessage));
    }
    @Then("Test asserts that the text box is enabled.")
    public void test_asserts_that_the_text_box_is_enabled() {
        Assert.assertTrue(dynamicControlPage.itIsEnabledDisabledMessage.getText().contains("enabled"));

    }
    @Then("Test clicks on the Disable Button and uses explicit wait.")
    public void test_clicks_on_the_disable_button_and_uses_explicit_wait() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        dynamicControlPage.EnableDisableButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(dynamicControlPage.itIsEnabledDisabledMessage));
    }
    @Then("Test asserts that the text box is disabled.")
    public void test_asserts_that_the_text_box_is_disabled() {
        Assert.assertTrue(dynamicControlPage.itIsEnabledDisabledMessage.getText().contains("disabled"));
    }


}
