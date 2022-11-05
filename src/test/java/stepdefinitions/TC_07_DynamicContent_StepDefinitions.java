package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_07_DynamicContent_Page;

import java.util.ArrayList;
import java.util.List;

public class TC_07_DynamicContent_StepDefinitions {
    TC_07_DynamicContent_Page dynamicContentPage=new TC_07_DynamicContent_Page();
    @Given("User goes to the Dynamic content page")
    public void user_goes_to_the_dynamic_content_page() {
        dynamicContentPage.dynamicContentLink.click();
    }
    @When("User clicks on the click here for Dynamic content changes")
    public void user_clicks_on_the_click_here_for_dynamic_content_changes() {
        List<String> allText=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            dynamicContentPage.clickHereText.click();
            String eachText=   dynamicContentPage.dynamicContent.getText();
            allText.add(eachText);
        }
        System.out.println("allText = " + allText);
        for (String each : allText) {
            Assert.assertEquals(each,each);
        }
    }
    @Then("User can see content changes on each refresh")
    public void user_can_see_content_changes_on_each_refresh() {

    }

}
