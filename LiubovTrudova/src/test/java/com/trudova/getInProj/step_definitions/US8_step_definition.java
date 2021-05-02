package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.DynamicLoadingPage;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US8_step_definition {
    private DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("navigate to Dynamic Loading {string}")
    public void navigate_to_dynamic_loading(String url) {
        Driver.getDriver().get(url);
    }

    @Given("click Start button")
    public void click_start_button() {
        dynamicLoadingPage.startBtn.click();
    }

    @Then("asserts that the message is {string}")
    public void asserts_that_the_message_is(String expected) {
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.helloWorldMsg));
        Assert.assertEquals(dynamicLoadingPage.helloWorldMsg.getText(), expected);
    }

}
