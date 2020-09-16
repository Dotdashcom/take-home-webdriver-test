package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IframeSteps {
    WebElement inputArea;

    @When("I click {string} link text")
    public void i_click_link_text(String option) {
        Driver.get().findElement(By.linkText(option)).click();
    }

    @When("I type {string} to the text input area")
    public void i_type_to_the_text_input_area(String inputText) {
        Driver.get().switchTo().frame("mce_0_ifr");
        inputArea = Driver.get().findElement(By.id("tinymce"));
        inputArea.clear();
        inputArea.sendKeys(inputText);
    }

    @Then("asserts that the typed text is {string}")
    public void asserts_that_the_typed_text_is(String expected) {
        Assert.assertEquals(expected, inputArea.getText());
    }
}
