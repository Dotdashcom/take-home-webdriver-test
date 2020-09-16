package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuSteps {
    @When("I right-click on the context menu")
    public void i_right_click_on_the_context_menu() {
        Actions actions = new Actions(Driver.get());
        WebElement contextArea = Driver.get().findElement(By.id("hot-spot"));
        actions.contextClick(contextArea).perform();
    }

    @Then("verify that alert has {string} message")
    public void verify_that_alert_has_message(String expectedMessage) {
        Assert.assertEquals(Driver.get().switchTo().alert().getText(), expectedMessage);
    }
}
