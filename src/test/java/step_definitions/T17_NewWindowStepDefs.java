package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.NewWindowPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Set;

public class T17_NewWindowStepDefs {

    NewWindowPage newWindowPage = new NewWindowPage();

    @Given("user is on {string} New Window page")
    public void user_is_on_new_window_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }

    @When("user clicks on Click Here link")
    public void user_clicks_on_click_here_link() {
        newWindowPage.clickHereBtn.click();
    }

    @Then("user should be able to verify that a new tab is opened with text New Window.")
    public void user_should_be_able_to_verify_that_a_new_tab_is_opened_with_text_new_window() {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String eachWindow : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindow);
            if (Driver.getDriver().getTitle().equals("New Window")) {
                break;
            }
        }
        Assert.assertEquals("New Window", newWindowPage.newWindowMessage.getText());
    }
}
