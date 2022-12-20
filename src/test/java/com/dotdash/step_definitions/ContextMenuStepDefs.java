package com.dotdash.step_definitions;

import com.dotdash.utilities.BrowserUtils;
import com.dotdash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContextMenuStepDefs extends BaseStep{

    @When("I right clicks on the context menu")
    public void i_right_clicks_on_the_context_menu() {
        BrowserUtils.waitForClickability(pages.contextMenuPage().contextMenu, 5);
        BrowserUtils.rightClick(pages.contextMenuPage().contextMenu);
    }
    @Then("I assert the alert menu text")
    public void i_assert_the_alert_menu_text() {
        String actual = Driver.getDriver().switchTo().alert().getText();
        assertThat(actual, containsString("You selected a context menu"));
    }
}
