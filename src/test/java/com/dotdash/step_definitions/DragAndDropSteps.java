package com.dotdash.step_definitions;

import com.dotdash.utilities.BrowserUtils;
import com.dotdash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DragAndDropSteps extends BaseStep {

    @When("I drag element A to element B")
    public void i_drag_element_a_to_element_b() {
        BrowserUtils.waitForVisibility(pages.dragAndDropPage().columnA, 5);
        Actions act = new Actions(Driver.getDriver());
        act.dragAndDrop(pages.dragAndDropPage().columnA, pages.dragAndDropPage().columnB).build().perform();
    }
    @Then("I assert that the text on element A and B are switched")
    public void i_assert_that_the_text_on_element_a_and_b_are_switched() {
        String actual = pages.dragAndDropPage().ColumnAHeader.getText();
        assertThat(actual, containsString("B"));
    }

}
