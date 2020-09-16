package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class NotificationMessageSteps {
    @Then("assert that one of the message is displayed:")
    public void assertThatOneOfTheMessageIsDisplayed(List<String> dataTable) {
        String actText = Driver.get().findElement(By.id("flash")).getText().split("\n")[0];
        Assert.assertTrue(dataTable.contains(actText));
    }
}
