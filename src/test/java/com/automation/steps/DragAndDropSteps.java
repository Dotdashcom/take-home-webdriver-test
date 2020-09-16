package com.automation.steps;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragAndDropSteps {

    String[] before = new String[2];

    @When("I drag element A to element B")
    public void i_drag_element_to_element() {
        Actions actions = new Actions(Driver.get());

        List<WebElement> columns = Driver.get().findElements(By.cssSelector("#columns>div"));
        WebElement column_A = columns.get(0), column_B = columns.get(1);

        before[0] = column_A.getText();
        before[1] = column_B.getText();

        //actions.dragAndDrop(column_A, column_B).build().perform();
        actions.clickAndHold(column_A)
                .moveToElement(column_B)
                .release(column_B)
                .build().perform();

        BrowserUtils.wait(3000);
    }

    @Then("verify that that the text on element A and B are switched.")
    public void verify_that_that_the_text_on_element_and_are_switched() {
        List<WebElement> columns = Driver.get().findElements(By.cssSelector("#columns>div"));
        WebElement column_A = columns.get(0), column_B = columns.get(1);

        Assert.assertEquals(before[0], column_B.getText());
        Assert.assertEquals(before[1], column_A.getText());
    }
}
