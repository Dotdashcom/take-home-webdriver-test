package com.theInternet.StepDefinitions;

import com.theInternet.Pages.dynamicContentPage;
import com.theInternet.Utilities.ConfigurationReader;
import com.theInternet.Utilities.Driver;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class dynamicContentStepDefs {
    dynamicContentPage dynamicContent = new dynamicContentPage();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    @Given("User on Dynamic Content page")
    public void user_on_Dynamic_Content_page() {
        System.out.println("Opening the Drop Down page");
        Driver.get().get(ConfigurationReader.get("baseURL") + "dynamic_content");
    }

    @When("User refreshes the page")
    public void user_refreshes_the_page() {
        list1.add(dynamicContent.firstText.getText());
        list1.add(dynamicContent.secondText.getText());
        list1.add(dynamicContent.thirdText.getText());
        Driver.get().navigate().refresh();
        list2.add(dynamicContent.firstText.getText());
        list2.add(dynamicContent.secondText.getText());
        list2.add(dynamicContent.thirdText.getText());
    }

    @Then("Content changes each time")
    public void content_changes_each_time() {
        assertNotEquals(list1, list2);
    }
}
