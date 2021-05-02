package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.DynamicContentPage;
import com.trudova.getInProj.utilities.BrowserUtility;
import com.trudova.getInProj.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US6_step_definition {
    private DynamicContentPage dynamicContentPage = new DynamicContentPage();

    @Given("navigate to Dynamic Content")
    public void navigate_to_dynamic_content() {
        dynamicContentPage.dynamicContent.click();
    }


    @Then("asserts that the content changes on each refresh.")
    public void asserts_that_the_content_changes_on_each_refresh() {
        List<String> textContent = BrowserUtility.translateToStrList(dynamicContentPage.contentList);
        Driver.getDriver().navigate().refresh();
        List<String> newTextContent = BrowserUtility.translateToStrList(dynamicContentPage.contentList);
        Assert.assertFalse(newTextContent.equals(textContent));

    }

}
