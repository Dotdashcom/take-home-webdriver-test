package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicLoadingSteps {
    @When("I click on first example and click start button")
    public void i_click_on_first_example_and_click_start_button() {
        Driver.get().findElement(By.xpath("//a[contains(text(),'Example 1')]")).click();
        Driver.get().findElement(By.tagName("button")).click();
    }

    @Then("assert that {string} text is displayed.")
    public void assert_that_text_is_displayed(String message) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),20);
        List<WebElement> loader = Driver.get().findElements(By.id("loading"));

        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

        String actualMessage = Driver.get().findElement(By.id("finish")).getText();
        Assert.assertEquals(message,actualMessage);
    }
}
