package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class T04_ContextBoxStepDefs {

    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Given("user is on the {string} page")
    public void user_is_on_the_page(String endpoint) {
        Driver.getDriver().get(ConfigurationReader.getProperty("BaseUrl") + endpoint);
    }
    @When("user right clicks on the context box")
    public void user_right_clicks_on_the_context_box() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenuPage.contextMenu).perform();
    }
    @Then("user verifies alert text")
    public void user_verifies_alert_text() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(ConfigurationReader.getProperty("contextMenuText"),alertText);
    }

}
