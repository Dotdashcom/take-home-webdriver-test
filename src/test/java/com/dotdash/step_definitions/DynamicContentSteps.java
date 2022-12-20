package com.dotdash.step_definitions;

import com.dotdash.utilities.BrowserUtils;
import com.dotdash.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DynamicContentSteps extends BaseStep {
    private String content;
    @When("I refresh the page")
    public void i_refresh_the_page() {
        BrowserUtils.waitForVisibility(pages.dynamicContentPage().firstContent, 5);
        content = pages.dynamicContentPage().firstContent.getText();
        Driver.getDriver().navigate().refresh();

    }
    @Then("I assert that the content changes on refresh")
    public void i_assert_that_the_content_changes_on_refresh() {
        String actual = pages.dynamicContentPage().firstContent.getText();
        assertThat(content, is(not(equals(actual))));
        content = actual;
    }
}
