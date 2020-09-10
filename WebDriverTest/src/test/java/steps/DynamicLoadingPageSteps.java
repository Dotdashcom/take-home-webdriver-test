package steps;

import base.Functions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DynamicLoadingPageSteps extends Functions {

    @When("user clicks Start button")
    public void user_clicks_Start_button() {

        click(dynamicLoadingPage.startBtn);

    }

    @Then("user sees {string}")
    public void user_sees(String expectedMessage) {

        String actualMessage = waitForVisibility(dynamicLoadingPage.message).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
