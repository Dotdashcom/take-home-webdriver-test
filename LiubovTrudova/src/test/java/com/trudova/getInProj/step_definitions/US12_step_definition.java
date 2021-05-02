package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.IframePage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US12_step_definition {
    private IframePage iframePage = new IframePage();

    @Given("navigate to {string}")
    public void navigate_to(String url) {
        Driver.getDriver().get(url);
    }

    @When("navigate to Iframe type {string}")
    public void navigate_to_iframe_type(String text) {
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        iframePage.textInp.clear();
        iframePage.textInp.sendKeys(text);
    }

    @Then("verify {string} is presented")
    public void verify_is_presented(String string) {
        Assert.assertTrue(iframePage.textInp.getText().equals(string));
    }
}
