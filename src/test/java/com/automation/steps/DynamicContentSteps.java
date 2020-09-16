package com.automation.steps;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DynamicContentSteps {

    @Then("assert that content changes on each refresh")
    public void assert_that_content_changes_on_each_refresh() {
        String textBefore = Driver.get().findElements(By.cssSelector(".large-10.columns")).get(1).getText();
        Driver.get().navigate().refresh();
        String textAfter = Driver.get().findElements(By.cssSelector(".large-10.columns")).get(1).getText();

        System.out.println("Text before: "+ textBefore);
        System.out.println("Text after: "+ textAfter);
        Assert.assertNotEquals(textBefore, textAfter);
    }
}
