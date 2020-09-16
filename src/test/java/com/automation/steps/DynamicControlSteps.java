package com.automation.steps;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicControlSteps {

    public void clickAndWait(WebElement element){
        element.click();
        WebDriverWait wait = new WebDriverWait(Driver.get(),20);
        List<WebElement> loader = Driver.get().findElements(By.id("loading"));

        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));
    }


    @When("I click on {string} button")
    public void i_click_on_button(String button) {
        List<WebElement> buttons = Driver.get().findElements(By.tagName("button"));

        for(WebElement e: buttons){
            if(e.getText().equals(button)) clickAndWait(e);
        }

    }

    @Then("assert that the checkbox is {string}")
    public void assert_that_the_checkbox_is(String isVisible) {
        List<WebElement> checkboxes = Driver.get().findElements(By.id("checkbox"));
        boolean isVisibleActual = checkboxes.size() != 0 && checkboxes.get(0).isDisplayed();
        if(isVisible.equals("visible"))  {
            Assert.assertTrue(isVisibleActual);
        } else if(isVisible.equals("not visible"))  {
            Assert.assertFalse(isVisibleActual);
        }
    }

    @Then("assert that the text box is {string}")
    public void assert_that_the_text_box_is(String isEnabled) {
        boolean isEnabledActual = Driver.get().findElement(By.cssSelector("#input-example>input")).isEnabled();

        if(isEnabled.equals("enabled")) Assert.assertTrue(isEnabledActual);
        else Assert.assertFalse(isEnabledActual);
    }


}
