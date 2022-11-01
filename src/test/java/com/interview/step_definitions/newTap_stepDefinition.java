package com.interview.step_definitions;

import com.interview.pages.NewTapPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Set;

public class newTap_stepDefinition {
NewTapPage newTapPage=new NewTapPage();
    @Given("user is on the Open in new Tap page")
    public void user_is_on_the_open_in_new_tap_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/windows");
    }




    @When("user clicks on the Click Here link")
    public void user_clicks_on_the_click_here_link() {
     newTapPage.ClickHere.click();

    }
    @Then("asserts that a new tab is opened with text New Window")
    public void asserts_that_a_new_tab_is_opened_with_text_new_window() {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current Title while switching: " + Driver.getDriver().getTitle());
        }

        String finalExpected = "New Window";
        String finalActualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(finalActualTitle, finalExpected);


    }

    }
