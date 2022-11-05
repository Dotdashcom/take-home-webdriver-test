package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_09_DynamicLoading_Page;
import utilities.ReusableMethods;

public class TC_09_DynamicLoading_StepDefinitions {
    TC_09_DynamicLoading_Page dynamicLoadingPage=new TC_09_DynamicLoading_Page();
    @Given("User goes to the dynamic loading page")
    public void user_goes_to_the_dynamic_loading_page() {
    dynamicLoadingPage.dynamicLoadingLink.click();
    dynamicLoadingPage.example1.click();
    }
    @When("User clicks the start button and uses explicit wait.")
    public void user_clicks_the_start_button_and_uses_explicit_wait() {
    dynamicLoadingPage.startButton.click();
        ReusableMethods.waitForVisibility(dynamicLoadingPage.helloWorld, 10);
    }
    @Then("User Asserts that “Hello World!” text is displayed.")
    public void user_asserts_that_hello_world_text_is_displayed() {
            String actualText=dynamicLoadingPage.helloWorld.getText();
            String expectedText="Hello World!";
            Assert.assertEquals(actualText,expectedText);
    }
}
