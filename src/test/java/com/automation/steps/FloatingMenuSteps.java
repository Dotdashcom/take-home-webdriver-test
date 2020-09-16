package com.automation.steps;

import com.automation.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FloatingMenuSteps {

    @Then("assert that the floating menu is displayed")
    public void assert_that_the_floating_menu_is_displayed() {
        List<WebElement> floatingMenus = Driver.get().findElements(By.tagName("li"));
        floatingMenus.forEach(menu-> Assert.assertTrue(menu.isDisplayed()));
    }

    @Then("I scroll down until by {string} px")
    public void i_scroll_down_until_I_see(String amount) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0, "+amount+")" );
    }

}
