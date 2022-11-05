package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC_17_OpenInNewTab_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class TC_17_OpenInNewTab_StepDefinitions {
    TC_17_OpenInNewTab_Page openInNewTabPage=new TC_17_OpenInNewTab_Page();
    @Given("User goes in the Open in new Tap page")
    public void user_goes_in_the_open_in_new_tap_page() {
        Driver.getDriver().get(ConfigReader.getProperty("openWindowUrl"));
    }
    @When("User clicks on the Click Here link")
    public void user_clicks_on_the_click_here_link() {
    openInNewTabPage.clickHere.click();
    }
    @Then("User asserts that a new tab is opened with text New Window")
    public void user_asserts_that_a_new_tab_is_opened_with_text_new_window() {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("switching windows: " + Driver.getDriver().getTitle());
        }

        String finalExpected = "New Window";
        String finalActualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(finalActualTitle, finalExpected);

    }

}
