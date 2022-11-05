package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_16_JavaScriptEror_Page;

public class TC_16_JavaScriptEror_StepDefinitions {
    TC_16_JavaScriptEror_Page javaScriptErrorPage=new TC_16_JavaScriptEror_Page();
    @When("User goes to the JavaScript Error page")
    public void user_goes_to_the_java_script_error_page() {
    javaScriptErrorPage.JavaScriptErorLink.click();
    }
    @Then("User can see asserts that the page contains error")
    public void user_can_see_asserts_that_the_page_contains_error() {
        Assert.assertTrue(javaScriptErrorPage.text.getText().contains("error"));
    }

}
