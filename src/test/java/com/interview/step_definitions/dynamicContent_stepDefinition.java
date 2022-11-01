package com.interview.step_definitions;

import com.interview.pages.DynamicContentPage;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class dynamicContent_stepDefinition {
DynamicContentPage dynamicContentPage=new DynamicContentPage();
    @Given("user is on the Dynamic content page")
    public void user_is_on_the_dynamic_content_page() {
        String url= ConfigurationReader.getProperty("baseUrl");
        Driver.getDriver().get(url+"/dynamic_content");
    }




    @When("user clicks on the click here for  Dynamic content  changes")
    public void user_clicks_on_the_click_here_for_dynamic_content_changes() {
       List<String>allText=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            dynamicContentPage.clickHereButton.click();
         String eachText=   dynamicContentPage.dynamicContent.getText();
         allText.add(eachText);
        }
        System.out.println("allText = " + allText);
        for (String each : allText) {
            Assert.assertEquals(each,each);
        }

    }
    @Then("content changes on each refresh")
    public void content_changes_on_each_refresh() {


    }


}
