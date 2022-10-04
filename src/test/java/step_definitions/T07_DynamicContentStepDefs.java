package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DynamicContentPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.*;

public class T07_DynamicContentStepDefs {

    DynamicContentPage dynamicContentPage = new DynamicContentPage();

    String initialContent;

    @Given("user is on the {string} Dynamic Content page")
    public void user_is_on_the_dynamic_content_page(String endpointDynamic) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpointDynamic);
    }
    @When("user refreshes the page")
    public void user_refreshes_the_page() {
        Driver.getDriver().navigate().refresh();
        initialContent = dynamicContentPage.dynamicContent.getText();
    }
    @Then("user asserts that page content is changing and not same")
    public void user_asserts_that_page_content_is_changing_and_not_same() {
        Driver.getDriver().navigate().refresh();
        assertNotEquals(initialContent, dynamicContentPage.dynamicContent.getText());
    }

}
